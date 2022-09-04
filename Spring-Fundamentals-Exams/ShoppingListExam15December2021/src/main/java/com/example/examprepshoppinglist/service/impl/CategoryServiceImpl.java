package com.example.examprepshoppinglist.service.impl;

import com.example.examprepshoppinglist.model.entity.Category;
import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.examprepshoppinglist.repository.CategoryRepository;
import com.example.examprepshoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() > 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    category.setDescription("Description for " + categoryNameEnum.name());

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}

