package com.shulgin.yandex.yandex.controller;

import com.shulgin.yandex.yandex.dto.Item;
import com.shulgin.yandex.yandex.dto.Items;
import com.shulgin.yandex.yandex.response.NodeResponse;
import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.exception.ItemNotFoundException;
import com.shulgin.yandex.yandex.exception.ValidationException;
import com.shulgin.yandex.yandex.service.CategoryService;
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

    @PostMapping("imports")
    public void imports(@RequestBody Items items) throws ValidationException{
        OffsetDateTime dateTime;
        try {
            dateTime  = OffsetDateTime.parse(items.getUpdateDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new ValidationException();
        }
        for (Item item : items.getItems()) {
            if(item.getType().equals("CATEGORY")) {
                Category category = new Category(item.getId(), item.getName(), dateTime, item.getPrice());
                categoryService.addCategory(category, item.getParentId());
            } else if(item.getType().equals("OFFER")) {
                Offer offer = new Offer(item.getId(), item.getName(), dateTime);
                offerService.addOffer(offer, item.getParentId(), item.getPrice());
            } else {
                throw new ValidationException();
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
        Category category = categoryService.findCategoryByCode(id);
        Offer offer = offerService.findOfferById(id);
        if(offer != null) {
            return buildOffer(offer);
        } else if(category != null) {
            return buildCategory(category);
        }
        throw new ItemNotFoundException();
    }
}
