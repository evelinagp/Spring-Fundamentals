package com.example.examprepcoffeeshop.service.impl;

import com.example.examprepcoffeeshop.model.entity.User;
import com.example.examprepcoffeeshop.model.service.UserServiceModel;
import com.example.examprepcoffeeshop.model.view.UserViewModel;
import com.example.examprepcoffeeshop.repository.UserRepository;
import com.example.examprepcoffeeshop.service.UserService;
import com.example.examprepcoffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        //If we return void in Service there will be no need of mapping!
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
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
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc() {
        return userRepository.findAllByOrdersCountDesc().stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
