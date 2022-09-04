package com.example.examprepcoffeeshop.service;

import com.example.examprepcoffeeshop.model.entity.Category;
import com.example.examprepcoffeeshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
