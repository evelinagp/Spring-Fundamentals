package com.example.examprepandreys.service;


import com.example.examprepandreys.model.service.UserServiceModel;

public interface UserService {
//    boolean isNameExists(String username);


//    void registerUser(UserServiceModel userServiceModel);
//
//
//
    UserServiceModel findUserByUsernameAndPassword(String username, String password);



    void loginUser(String id, String username);

    void registerUser(UserServiceModel userServiceModel);
//
//    User findById(Long id);
//
//    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
