package com.shulgin.yandex.yandex.util;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.entity.Offer;
import com.shulgin.yandex.yandex.entity.Price;
import com.shulgin.yandex.yandex.response.NodeResponse;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResponseUtils {

    public static NodeResponse buildOffer(Offer offer) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        int lastPriceIndex = offer.getPrices().size() - 1;
        Price price = offer.getPrices().get(lastPriceIndex);
        String parent = offer.getCategory() != null ? offer.getCategory().getCode() : null;
        return new NodeResponse("OFFER", offer.getName(), offer.getId(),
                price.getPrice(), parent, offer.getDateTime().atZoneSameInstant(ZoneId.of("+00:00")).format(dtf), null);
    }

    public static NodeResponse buildCategory(Category category) {
        String parent = category.getParentCategory() != null ? category.getParentCategory().getCode() : null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        NodeResponse node = new NodeResponse("CATEGORY", category.getName(), category.getCode(),
                null, parent, category.getDateTime()
                .atZoneSameInstant(ZoneId.of("+00:00"))
                .format(dtf), null);
        List<Category> listChildrenCategory = category.getChildrenCategory();
        System.out.println(category.getDateTime().format(dtf));
        List<Offer> offers = category.getOffers();
        int countChildren = offers.size() + listChildrenCategory.size();
        NodeResponse[] children = new NodeResponse[countChildren];
        int i = 0;
        int offerCountInCategories = 0;
        int offerSumInCategories = 0;
        for(Category childCategory : listChildrenCategory) {
            children[i] = buildCategory(childCategory);
            offerCountInCategories += children[i].getOfferCountInCategory();
            offerSumInCategories += children[i].getOfferSumInCategory();
            i++;
        }
        long sum = 0;
        for(Offer offer : offers) {
            children[i] = buildOffer(offer);
            sum += children[i].getPrice();
            i++;
        }
        node.setChildren(children);
        node.setOfferCountInCategory(offers.size() + offerCountInCategories);
        node.setOfferSumInCategory(sum + offerSumInCategories);
        node.setPrice(node.getOfferSumInCategory() / node.getOfferCountInCategory());
        return node;
    }
}
