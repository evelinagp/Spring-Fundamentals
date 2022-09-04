package com.example.examprepshoppinglist.service.impl;

import com.example.examprepshoppinglist.model.entity.User;
import com.example.examprepshoppinglist.model.service.UserServiceModel;
import com.example.examprepshoppinglist.repository.UserRepository;
import com.example.examprepshoppinglist.service.UserService;
import com.example.examprepshoppinglist.util.CurrentUser;
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

    @Override
    public boolean isNameExists(String username) {
            return this.userRepository.existsByUsername(username);
    }

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
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
