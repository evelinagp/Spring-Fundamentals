package com.example.examprepandreys.model.binding;

import com.example.examprepandreys.model.entity.Category;
import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;
import com.example.examprepandreys.model.entity.enums.SexNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryNameEnum category;
    private SexNameEnum gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    @NotBlank(message = "Name can not be empty str")
    @Size(min = 2, message = "Name length must be more than two characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Price cannot be empty field.")
    @Positive(message = "Price must be positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "You must select the category")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    @NotNull(message = "You must select the gender")
    public SexNameEnum getGender() {
        return gender;
    }

    public void setGender(SexNameEnum gender) {
        this.gender = gender;
    }
}
