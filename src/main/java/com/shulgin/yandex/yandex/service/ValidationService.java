package com.shulgin.yandex.yandex.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidationService {
    boolean checkOfferId(String id);
    boolean checkCategoryId(String id);
    boolean checkParentId(String id);
    boolean checkName(String name);
    boolean checkCategoryPrice(Long price);
    boolean checkOfferPrice(Long price);
}
