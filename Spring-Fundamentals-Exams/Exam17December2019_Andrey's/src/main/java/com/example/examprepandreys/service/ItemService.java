package com.example.examprepandreys.service;


import com.example.examprepandreys.model.service.ItemServiceModel;
import com.example.examprepandreys.model.view.ItemViewModel;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemService {


    void addNewItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

//    BigDecimal getTotalSum();


    ItemViewModel findItemById(String id);

    void buyAll();

    // BigDecimal checkProductsSum();

    Integer findAllItemsCount();


    void delete(String id);


//    List<ItemViewModel> listAllItems();
}
