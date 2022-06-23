package com.shulgin.yandex.yandex.repository;

import com.shulgin.yandex.yandex.entity.Offer;
import org.springframework.data.repository.CrudRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface OfferRepo extends CrudRepository<Offer, Long> {
    Offer findOfferById(String id);
    List<Offer> findByDateTimeBetween(OffsetDateTime startDate, OffsetDateTime endDate);
}
