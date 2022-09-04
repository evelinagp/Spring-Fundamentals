package com.example.examprepcoffeeshop.model.entity;

import com.example.examprepcoffeeshop.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
    @Positive
    @Column(name = "needed_time",nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }
}

