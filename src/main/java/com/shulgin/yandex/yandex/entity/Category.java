package com.shulgin.yandex.yandex.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    private OffsetDateTime dateTime;
    @Transient
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id", foreignKey=@ForeignKey(name = "FK_PARENT_ID"))
    private Category parentCategory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Category> childrenCategory = new ArrayList<>();

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Offer> offers;

    public Category() {
    }

    public Category(String code, String name, OffsetDateTime dateTime, Long price) {
        this.code = code;
        this.name = name;
        this.dateTime = dateTime;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> set) {
        this.offers = set;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getChildrenCategory() {
        return childrenCategory;
    }

    public void setChildrenCategory(List<Category> childrenCategory) {
        this.childrenCategory = childrenCategory;
    }
}
