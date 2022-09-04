package com.example.examprepshoppinglist.service;

import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.examprepshoppinglist.model.service.ProductServiceModel;
import com.example.examprepshoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addNewProduct(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum);

    void buyById(Long id);

    void buyAll();

    BigDecimal checkProductsSum();
}
