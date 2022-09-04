package com.example.examprepshoppinglist.service;

import com.example.examprepshoppinglist.model.entity.Category;
import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
