package com.example.examprepshoppinglist.repository;

import com.example.examprepshoppinglist.model.entity.Product;
import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT sum(p.price) FROM Product p")
    BigDecimal findTotalProductsSum();


    List<Product> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);
}
