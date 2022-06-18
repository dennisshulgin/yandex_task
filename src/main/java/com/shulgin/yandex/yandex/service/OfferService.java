package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface OfferService {
    void addOffer(Offer offer, String parentId, BigDecimal price);
    boolean deleteOffer(String id);
}
