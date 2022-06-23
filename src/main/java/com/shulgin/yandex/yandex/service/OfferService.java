package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public interface OfferService {
    boolean addOffer(Offer offer, String parentId);
    boolean deleteOffer(String id);
    Offer findOfferById(String id);
    List<Offer> getOffersWasChangedInPeriod(OffsetDateTime startDate, OffsetDateTime endDate);
}
