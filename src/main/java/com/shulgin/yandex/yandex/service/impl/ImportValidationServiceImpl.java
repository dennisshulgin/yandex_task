package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.dto.Imports;
import com.shulgin.yandex.yandex.dto.Item;
import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.ImportValidationService;
import com.shulgin.yandex.yandex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

@Service
public class ImportValidationServiceImpl implements ImportValidationService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OfferService offerService;

    private final HashSet<String> categoriesIdSet = new HashSet<>();
    private final HashSet<String> offersIdSet = new HashSet<>();

    public boolean isValidImportsData(Imports importObject) {
        categoriesIdSet.clear();
        offersIdSet.clear();
        return isValidItems(importObject.getItems()) && isISODateTime(importObject.getUpdateDate());
    }

    private boolean isValidItems(Item[] items) {
        for(Item item : items) {
            String type = item.getType();
            if(!isTypeCorrect(type)) {
                return false;
            }
            if(type.equals("CATEGORY") && !isValidCategoryItem(item)) {
                return false;
            } else if(type.equals("OFFER") && !isValidOfferItem(item)) {
                return false;
            }
        }
        return isValidParents(items);
    }

    private boolean isValidParents(Item[] items) {
        for(Item item : items) {
            String id = item.getId();
            String parentId = item.getParentId();
            if(offersIdSet.contains(parentId) || id.equals(parentId)) {
                return false;
            }
            Category categoryFromDB = categoryService.findCategoryByCode(parentId);
            if (categoryFromDB == null && !categoriesIdSet.contains(parentId) && parentId != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidOfferItem(Item item) {
        String id = item.getId();
        String name = item.getName();
        Long price = item.getPrice();
        if(isIdNull(id)) {
            return false;
        }
        if(isNameNull(name)) {
            return false;
        }
        if(!isOfferPriceCorrect(price)) {
            return false;
        }
        if(categoriesIdSet.contains(id) || offersIdSet.contains(id)) {
            return false;
        }
        if(categoryService.findCategoryByCode(id) != null) {
            return false;
        }
        offersIdSet.add(id);
        return true;

    }

    private boolean isValidCategoryItem(Item item) {
        String id = item.getId();
        String name = item.getName();
        Long price = item.getPrice();
        if(isIdNull(id)) {
            return false;
        }
        if(isNameNull(name)) {
            return false;
        }
        if(isCategoryPriceNotNull(price)) {
            return false;
        }
        if(categoriesIdSet.contains(id) || offersIdSet.contains(id)) {
            return false;
        }
        if(offerService.findOfferById(id) != null) {
            return false;
        }
        categoriesIdSet.add(id);
        return true;
    }

    private boolean isIdNull(String id) {
        return id == null;
    }

    private boolean isTypeCorrect(String type) {
        return type != null && (type.equals("CATEGORY") || type.equals("OFFER"));
    }

    private boolean isOfferPriceCorrect(Long price) {
        return price != null && price >= 0;
    }

    private boolean isCategoryPriceNotNull(Long price) {
        return price != null;
    }

    private boolean isNameNull(String name) {
        return name == null;
    }

    private boolean isISODateTime(String date) {
        try {
            OffsetDateTime dateTime  = OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
