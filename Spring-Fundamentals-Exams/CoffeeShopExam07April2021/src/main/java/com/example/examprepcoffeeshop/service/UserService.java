package com.example.examprepcoffeeshop.service;

import com.example.examprepcoffeeshop.model.entity.User;
import com.example.examprepcoffeeshop.model.service.UserServiceModel;
import com.example.examprepcoffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
   // boolean isEntityExist(String username);

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
