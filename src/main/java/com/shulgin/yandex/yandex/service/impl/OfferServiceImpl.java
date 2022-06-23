package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.entity.Price;
import com.shulgin.yandex.yandex.repository.OfferRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepo offerRepo;

    @Autowired
    private CategoryService categoryService;

    public boolean addOffer(Offer offer, String parentCode, Long price) {
        OffsetDateTime updateDate = offer.getDateTime();
        Category categoryFromDB = categoryService.findCategoryByCode(parentCode);
        Offer offerFromDB = offerRepo.findOfferById(offer.getId());
        if(parentCode != null && categoryFromDB == null) {
            categoryFromDB = new Category(parentCode, "undefined", updateDate, null);
            categoryService.saveCategory(categoryFromDB);
        }
        if (offerFromDB == null) {
            offer.setCategory(categoryFromDB);
            Price priceObject = new Price(offer.getDateTime(), price, offer);
            List<Price> pricesList = new ArrayList<>();
            pricesList.add(priceObject);
            offer.setPrices(pricesList);
        } else {
            offer.setCategory(categoryFromDB);
            Price priceObject = new Price(offer.getDateTime(), price, offer);
            List<Price> pricesList = offerFromDB.getPrices();
            pricesList.add(priceObject);
            offer.setPrices(pricesList);
        }
        offerRepo.save(offer);
        while(categoryFromDB != null) {
            categoryFromDB.setDateTime(updateDate);
            categoryService.saveCategory(categoryFromDB);
            categoryFromDB = categoryFromDB.getParentCategory();
        }
        return true;
    }

    public boolean deleteOffer(String id) {
        Offer offerFromDB = offerRepo.findOfferById(id);
        if(offerFromDB == null) {
            return false;
        }
        offerRepo.delete(offerFromDB);
        return true;
    }

    public Offer findOfferById(String id) {
        return offerRepo.findOfferById(id);
    }
}
