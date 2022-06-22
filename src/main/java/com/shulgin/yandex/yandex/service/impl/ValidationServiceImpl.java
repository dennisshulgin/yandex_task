package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.OfferService;
import com.shulgin.yandex.yandex.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;

    public boolean checkOfferId(String id) {
        Category category = categoryService.findCategoryByCode(id);
        return category == null;
    }

    public boolean checkCategoryId(String id) {
        Offer offer = offerService.findOfferById(id);
        return offer == null;
    }

    public boolean checkParentId(String id) {
        Category category = categoryService.findCategoryByCode(id);
        return category != null;
    }

    public boolean checkName(String name) {
        return name != null;
    }

    public boolean checkCategoryPrice(Long price) {
        return price == null;
    }

    public boolean checkOfferPrice(Long price) {
        return price != null && price >= 0;
    }
}
