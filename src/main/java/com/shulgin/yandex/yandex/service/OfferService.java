package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {
    boolean addOffer(Offer offer, String parentId, Long price);
    boolean deleteOffer(String id);
    Offer findOfferById(String id);
}
