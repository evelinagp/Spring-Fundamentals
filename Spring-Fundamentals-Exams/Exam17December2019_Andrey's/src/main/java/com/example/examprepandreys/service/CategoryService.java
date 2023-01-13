package com.example.examprepandreys.service;


import com.example.examprepandreys.model.entity.Category;
import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
