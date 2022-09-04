package com.example.examprepshoppinglist.model.binding;

import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {
    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryNameEnum category;

    public ProductAddBindingModel() {
    }

    @NotBlank(message = "Name can not be empty str")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, message = "Description must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @FutureOrPresent(message = "The date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }
    //@DecimalMin(value > "0")

    @Positive(message = "The price must be positive")
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
}
