package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {
    void addOffer(Offer offer, String parentId, long price);
    boolean deleteOffer(String id);
    Offer findOfferById(String id);
}
