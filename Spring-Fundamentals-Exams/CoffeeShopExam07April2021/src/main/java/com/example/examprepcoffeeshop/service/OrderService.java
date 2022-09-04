package com.example.examprepcoffeeshop.service;


import com.example.examprepcoffeeshop.model.entity.Order;
import com.example.examprepcoffeeshop.model.service.OrderServiceModel;
import com.example.examprepcoffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addNewOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);
}
