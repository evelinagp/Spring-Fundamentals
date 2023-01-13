package com.example.examprepandreys.repository;

import com.example.examprepandreys.model.entity.Item;
import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


//   @Query("SELECT sum(i.price) FROM Item i")
//    BigDecimal findTotalProductsSum();


    List<Item> findAllByCategory_Name(CategoryNameEnum categoryNameEnum);


    Optional<Item> findById(String id);
    void deleteItemById(String id);

    @Query("SELECT COUNT(i) from Item i ")
    Integer findItemsByTotalCount();

}
