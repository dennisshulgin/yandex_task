package com.shulgin.yandex.yandex.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private OffsetDateTime dateTime;
    private long price;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Price(OffsetDateTime dateTime, long price, Offer offer) {
        this.dateTime = dateTime;
        this.price = price;
        this.offer = offer;
    }

    public Price() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
