package com.shulgin.yandex.yandex.controller;

import com.shulgin.yandex.yandex.dto.Imports;
import com.shulgin.yandex.yandex.dto.Item;
import com.shulgin.yandex.yandex.response.NodeResponse;
import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.exception.ItemNotFoundException;
import com.shulgin.yandex.yandex.exception.ValidationException;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.ImportValidationService;
import com.shulgin.yandex.yandex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.shulgin.yandex.yandex.util.ResponseUtils.buildCategory;
import static com.shulgin.yandex.yandex.util.ResponseUtils.buildOffer;

@RestController
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ImportValidationService importValidationService;

    @PostMapping("imports")
    public void imports(@RequestBody Imports importObject) throws ValidationException{
        if (!importValidationService.isValidImportsData(importObject)) {
            throw new ValidationException();
        }
        OffsetDateTime updateDate;
        try {
            updateDate  = OffsetDateTime.parse(importObject.getUpdateDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new ValidationException();
        }
        for (Item item : importObject.getItems()) {
            String type = item.getType();
            if(type.equals("CATEGORY")) {
                Category category = new Category(item.getId(), item.getName(), updateDate, item.getPrice());
                categoryService.addCategory(category, item.getParentId());
            } else if(type.equals("OFFER")) {
                Offer offer = new Offer(item.getId(), item.getName(), updateDate);
                offerService.addOffer(offer, item.getParentId(), item.getPrice());
            }
        }
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) throws ItemNotFoundException, ValidationException {
        if(!(categoryService.deleteCategory(id) || offerService.deleteOffer(id))) {
            throw new ItemNotFoundException();
        }
    }

    @GetMapping("nodes/{id}")
    public NodeResponse nodes(@PathVariable String id) throws ItemNotFoundException, ValidationException {
        Category categoryFromDB = categoryService.findCategoryByCode(id);
        Offer offerFromDB = offerService.findOfferById(id);
        if(offerFromDB != null) {
            return buildOffer(offerFromDB);
        } else if(categoryFromDB != null) {
            return buildCategory(categoryFromDB);
        }
        throw new ItemNotFoundException();
    }
}
