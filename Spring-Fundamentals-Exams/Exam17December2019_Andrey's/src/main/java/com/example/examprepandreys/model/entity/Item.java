package com.example.examprepandreys.model.entity;

import com.example.examprepandreys.model.entity.enums.SexNameEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private SexNameEnum gender;

    public Item() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(optional = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public SexNameEnum getGender() {
        return gender;
    }

    public void setGender(SexNameEnum sex) {
        this.gender = sex;
    }
}
