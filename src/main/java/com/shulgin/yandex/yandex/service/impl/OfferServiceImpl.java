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

    public void addOffer(Offer offer, String parentCode, long price) {
        OffsetDateTime dateTime = offer.getDateTime();
        Category category = categoryService.findCategoryByCode(parentCode);
        Offer oldOffer = offerRepo.findOfferById(offer.getId());
        if (oldOffer == null) {
            offer.setCategory(category);
            Price newPrice = new Price(offer.getDateTime(), price, offer);
            List<Price> prices = new ArrayList<>();
            prices.add(newPrice);
            offer.setPrices(prices);
        } else {
            offer.setCategory(category);
            Price newPrice = new Price(offer.getDateTime(), price, offer);
            List<Price> prices = oldOffer.getPrices();
            Price lastPrice = prices.get(prices.size() - 1);
            if(newPrice.getPrice() != lastPrice.getPrice()) {
                prices.add(newPrice);
            }
            offer.setPrices(prices);
        }
        offerRepo.save(offer);
        while(category != null) {
            category.setDateTime(dateTime);
            categoryService.saveCategory(category);
            category = category.getParentCategory();
        }
    }

    public boolean deleteOffer(String id) {
        Offer offer = offerRepo.findOfferById(id);
        if(offer == null) {
            return false;
        }
        offerRepo.delete(offer);
        return true;
    }

    public Offer findOfferById(String id) {
        return offerRepo.findOfferById(id);
    }
}
