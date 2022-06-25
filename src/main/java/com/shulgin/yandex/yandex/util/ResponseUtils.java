package com.shulgin.yandex.yandex.util;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.response.NodeResponse;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResponseUtils {
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static NodeResponse buildOffer(Offer offer) {
        Long price = offer.getPrice();
        String parentId = offer.getCategory() != null ? offer.getCategory().getCode() : null;
        String dateTimeString = offer.getDateTime().atZoneSameInstant(ZoneId.of("+00:00")).format(dtf);
        String name = offer.getName();
        String id = offer.getId();
        return new NodeResponse("OFFER", name, id, price, parentId, dateTimeString , null);
    }

    public static NodeResponse buildCategory(Category category) {
        String parentId = category.getParentCategory() != null ? category.getParentCategory().getCode() : null;
        String name = category.getName();
        String code = category.getCode();
        String dateTimeString = category.getDateTime().atZoneSameInstant(ZoneId.of("+00:00")).format(dtf);
        NodeResponse node = new NodeResponse("CATEGORY", name, code, null, parentId, dateTimeString, null);
        List<Category> childrenCategoryList = category.getChildrenCategory();
        List<Offer> offerList = category.getOffers();
        int countChildren = offerList.size() + childrenCategoryList.size();
        NodeResponse[] children = new NodeResponse[countChildren];
        int index = 0;
        int offerCountInCategories = 0;
        int offerSumInCategories = 0;
        for(Category childCategory : childrenCategoryList) {
            children[index] = buildCategory(childCategory);
            offerCountInCategories += children[index].getOfferCountInCategory();
            offerSumInCategories += children[index].getOfferSumInCategory();
            index++;
        }
        long currentOfferSum = 0;
        for(Offer offer : offerList) {
            children[index] = buildOffer(offer);
            currentOfferSum += children[index].getPrice();
            index++;
        }
        node.setChildren(children);
        node.setOfferCountInCategory(offerList.size() + offerCountInCategories);
        node.setOfferSumInCategory(currentOfferSum + offerSumInCategories);
        if (node.getOfferCountInCategory() == 0) {
            node.setPrice(0L);
        } else {
            node.setPrice(node.getOfferSumInCategory() / node.getOfferCountInCategory());
        }
        return node;
    }
}
