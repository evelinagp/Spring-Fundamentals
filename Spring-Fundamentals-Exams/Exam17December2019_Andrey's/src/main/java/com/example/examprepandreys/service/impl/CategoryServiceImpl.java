package com.example.examprepandreys.service.impl;

import com.example.examprepandreys.model.entity.Category;
import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;
import com.example.examprepandreys.repository.CategoryRepository;
import com.example.examprepandreys.service.CategoryService;
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
    public Category findByCategoryNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);

    }
}
