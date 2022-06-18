package com.shulgin.yandex.yandex.dto;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String type;
    private String name;
    private String id;
    private String parentId;
    private BigDecimal price;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", price=" + price +
                '}';
    }
}
