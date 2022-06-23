package com.shulgin.yandex.yandex.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Offer {
    @Id
    private String id;
    private String name;
    private OffsetDateTime dateTime;
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Offer(String id, String name, OffsetDateTime dateTime, Long price) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.price = price;
    }

    public Offer() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
