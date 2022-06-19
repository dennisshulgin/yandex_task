package com.shulgin.yandex.yandex.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NodeResponse {
    private String type;
    private String name;
    private String id;
    private Long price;
    private String parentId;
    private String date;
    private NodeResponse[] children;

    @JsonIgnore
    private int offerCountInCategory = 0;
    @JsonIgnore
    private long offerSumInCategory = 0;

    public NodeResponse(String type,
                        String name,
                        String id,
                        Long price,
                        String parentId,
                        String date,
                        NodeResponse[] children) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.price = price;
        this.parentId = parentId;
        this.date = date;
        this.children = children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NodeResponse[] getChildren() {
        return children;
    }

    public void setChildren(NodeResponse[] children) {
        this.children = children;
    }

    public int getOfferCountInCategory() {
        return offerCountInCategory;
    }

    public void setOfferCountInCategory(int offerCountInCategory) {
        this.offerCountInCategory = offerCountInCategory;
    }

    public long getOfferSumInCategory() {
        return offerSumInCategory;
    }

    public void setOfferSumInCategory(long offerSumInCategory) {
        this.offerSumInCategory = offerSumInCategory;
    }
}
