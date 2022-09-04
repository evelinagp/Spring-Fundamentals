package com.example.examprepcoffeeshop.repository;

import com.example.examprepcoffeeshop.model.entity.Category;
import com.example.examprepcoffeeshop.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   Optional<Category> findByName(CategoryNameEnum categoryNameEnum);

}
