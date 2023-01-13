package com.example.examprepandreys.model.service;

import com.example.examprepandreys.model.entity.Category;
import com.example.examprepandreys.model.entity.enums.SexNameEnum;

import java.math.BigDecimal;

public class ItemServiceModel {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private SexNameEnum gender;

    public ItemServiceModel() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SexNameEnum getGender() {
        return gender;
    }

    public void setGender(SexNameEnum gender) {
        this.gender = gender;
    }
}
