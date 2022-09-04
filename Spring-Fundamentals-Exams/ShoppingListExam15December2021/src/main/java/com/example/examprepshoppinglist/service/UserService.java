package com.example.examprepshoppinglist.service;


import com.example.examprepshoppinglist.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    boolean isNameExists(String username);


    void registerUser(UserServiceModel userServiceModel);



    UserServiceModel findUserByUsernameAndPassword(String username, String password);



    void loginUser(Long id, String username);
//
//    User findById(Long id);
//
//    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
