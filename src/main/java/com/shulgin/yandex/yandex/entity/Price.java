package com.shulgin.yandex.yandex.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Price {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Offer offer;
    private java.sql.Date date;
    private java.sql.Time time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
