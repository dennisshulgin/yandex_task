package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.repository.OfferRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepo offerRepo;

    @Autowired
    private CategoryService categoryService;

    public boolean addOffer(Offer offer, String parentCode) {
        OffsetDateTime updateDate = offer.getDateTime();
        Category categoryFromDB = categoryService.findCategoryByCode(parentCode);
        Offer offerFromDB = offerRepo.findOfferById(offer.getId());
        if(parentCode != null && categoryFromDB == null) {
            categoryFromDB = new Category(parentCode, "undefined", updateDate, null);
            categoryService.saveCategory(categoryFromDB);
        }
        if (offerFromDB != null) {
            offerFromDB.setName(offer.getName());
            offerFromDB.setCategory(categoryFromDB);
            offerFromDB.setDateTime(updateDate);
            offerFromDB.setPrice(offer.getPrice());
            offerRepo.save(offerFromDB);
        } else {
            offer.setCategory(categoryFromDB);
            offerRepo.save(offer);
        }
        categoryService.updateDateParentCategories(categoryFromDB, updateDate);
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

    public List<Offer> getOffersWasChangedInPeriod(OffsetDateTime startDate, OffsetDateTime endDate) {
        return offerRepo.findByDateTimeBetween(startDate, endDate);
    }
}
