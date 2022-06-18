package com.shulgin.yandex.yandex.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Category {
    @Id
    private String id;
    private String name;
    private LocalDateTime dateTime;
    private String parentCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Offer> set;

    public Category() {
    }

    public Category(String id, String name, LocalDateTime dateTime, String parentCategory) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.parentCategory = parentCategory;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Offer> getSet() {
        return set;
    }

    public void setSet(Set<Offer> set) {
        this.set = set;
    }
}
