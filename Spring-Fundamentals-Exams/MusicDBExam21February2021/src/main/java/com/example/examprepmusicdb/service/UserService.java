package com.example.examprepmusicdb.service;

import com.example.examprepmusicdb.model.entity.User;
import com.example.examprepmusicdb.model.service.UserServiceModel;

public interface UserService {
   // boolean isNameExists(String username);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    User findByUserName(String username);


}
