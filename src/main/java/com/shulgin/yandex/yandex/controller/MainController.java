package com.shulgin.yandex.yandex.controller;

import com.shulgin.yandex.yandex.dto.Item;
import com.shulgin.yandex.yandex.dto.Items;
import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.exception.ValidationException;
import com.shulgin.yandex.yandex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
public class MainController {

    @Autowired
    private CategoryService categoryService;

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
                Category category = new Category(item.getId(), item.getName(), dateTime, item.getParentId());
                categoryService.addCategory(category);
            } else if(item.getType().equals("OFFER")) {
                //Offer offer = new Offer();
            } else {
                throw new ValidationException();
            }
        }
    }

    @GetMapping("imports")
    public void getR() {
        System.out.println(111);
    }
}
