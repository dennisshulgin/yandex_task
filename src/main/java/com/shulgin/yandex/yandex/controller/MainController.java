package com.shulgin.yandex.yandex.controller;

import com.shulgin.yandex.yandex.dto.Item;
import com.shulgin.yandex.yandex.dto.Items;
import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.exception.ItemNotFoundException;
import com.shulgin.yandex.yandex.exception.ValidationException;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.OfferService;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;

    @PostMapping("imports")
    public void imports(@RequestBody Items items) throws ValidationException{
        LocalDateTime dateTime;
        try {
            dateTime  = LocalDateTime.parse(items.getUpdateDate(), DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            throw new ValidationException();
        }
        for (Item item : items.getItems()) {
            if(item.getType().equals("CATEGORY")) {
                Category category = new Category(item.getId(), item.getName(), dateTime);
                categoryService.addCategory(category, item.getParentId());
            } else if(item.getType().equals("OFFER")) {
                Offer offer = new Offer(item.getId(), item.getName(), dateTime);
                offerService.addOffer(offer, item.getParentId(), item.getPrice());
            } else {
                throw new ValidationException();
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) throws ItemNotFoundException, ValidationException {
        if(!(categoryService.deleteCategory(id) || offerService.deleteOffer(id))) {
            throw new ItemNotFoundException();
        }
    }

    @GetMapping("imports/{code}")
    public Category getR(@PathVariable String code) {
        for (Offer o : categoryService.findCategoryByCode(code).getOffers()) {
            System.out.println(o.getName());
            System.out.println(o.getPrices());
        }
        System.out.println();
        return null;
    }
}
