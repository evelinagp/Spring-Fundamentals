package com.example.examprepmusicdb.service.impl;

import com.example.examprepmusicdb.model.entity.User;
import com.example.examprepmusicdb.model.service.UserServiceModel;
import com.example.examprepmusicdb.repository.UserRepository;
import com.example.examprepmusicdb.service.UserService;
import com.example.examprepmusicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private ModelMapper modelMapper;
    private CurrentUser currentUser;

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
        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);
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



    @Override
    public User findByUserName(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
