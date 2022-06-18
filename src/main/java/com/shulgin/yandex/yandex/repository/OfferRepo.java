package com.shulgin.yandex.yandex.repository;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepo extends CrudRepository<Offer, Long> {
    Offer findOfferById(String id);
}
