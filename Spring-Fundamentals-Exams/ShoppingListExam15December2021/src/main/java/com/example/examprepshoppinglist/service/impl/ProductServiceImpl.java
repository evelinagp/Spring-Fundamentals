package com.example.examprepshoppinglist.service.impl;

import com.example.examprepshoppinglist.model.entity.Product;
import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.examprepshoppinglist.model.service.ProductServiceModel;
import com.example.examprepshoppinglist.model.view.ProductViewModel;
import com.example.examprepshoppinglist.repository.ProductRepository;
import com.example.examprepshoppinglist.service.CategoryService;
import com.example.examprepshoppinglist.service.ProductService;
import com.example.examprepshoppinglist.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, CurrentUser currentUser, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;

        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void addNewProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByCategoryNameEnum(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum) {
        return productRepository.findAllByCategory_Name(categoryNameEnum)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }

    @Override
    public BigDecimal checkProductsSum() {
        BigDecimal totalProductsSum = productRepository.findTotalProductsSum();
        if (totalProductsSum == null) {
             totalProductsSum = BigDecimal.valueOf(0);
        }
        return totalProductsSum;
    }
}
