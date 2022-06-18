package com.shulgin.yandex.yandex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {
    @Id
    private String id;
    private String name;
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @OneToMany(mappedBy = "offer", fetch = FetchType.EAGER)
    private Set<Price> prices;

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
