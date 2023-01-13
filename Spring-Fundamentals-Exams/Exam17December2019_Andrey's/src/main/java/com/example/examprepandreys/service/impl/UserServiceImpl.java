package com.example.examprepandreys.service.impl;

import com.example.examprepandreys.model.entity.User;
import com.example.examprepandreys.model.service.UserServiceModel;
import com.example.examprepandreys.repository.UserRepository;
import com.example.examprepandreys.service.UserService;
import com.example.examprepandreys.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

//    @Override
//    public boolean isNameExists(String username) {
//        return this.userRepository.findByUsername(username);
//    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null)  ;

    }

    @Override
    public void loginUser(String id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
