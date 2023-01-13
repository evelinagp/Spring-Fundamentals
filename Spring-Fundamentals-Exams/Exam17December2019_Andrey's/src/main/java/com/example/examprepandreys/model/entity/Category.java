package com.example.examprepandreys.model.entity;

import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category_name")
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
