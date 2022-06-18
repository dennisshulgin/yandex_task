package com.shulgin.yandex.yandex.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Category {
    @Id
    private String id;
    private String name;
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category parentCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Category> childrenCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Offer> set;

    public Category() {
    }

    public Category(String id, String name, LocalDateTime dateTime/*, String parentCategory*/) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        //this.parentCategory = parentCategory;
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
