package com.example.examprepcoffeeshop.web;

import com.example.examprepcoffeeshop.model.binding.UserLoginBindingModel;
import com.example.examprepcoffeeshop.model.binding.UserRegisterBindingModel;
import com.example.examprepcoffeeshop.model.service.UserServiceModel;
import com.example.examprepcoffeeshop.repository.UserRepository;
import com.example.examprepcoffeeshop.service.UserService;
import com.example.examprepcoffeeshop.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserController(UserService userService, UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
        //StringBuilder sb = new StringBuilder();

        boolean isValid = validationUtil.isValid(userRegisterBindingModel)
                && !isEntityExist(userRegisterBindingModel.getUsername())
                && !isEmailExist(userRegisterBindingModel.getEmail());
          if (!isValid) {
              System.out.println("Existing username!");
                     // userRegisterBindingModel.getUsername());
              return "redirect:register";
          }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
//
//        return "redirect:login";
        return "redirect:login";
    }

    private boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    private boolean isEntityExist(String username) {
        return userRepository.existsByUsername(username);
    }



    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isExist", true);
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }
        UserServiceModel currentUser = userService
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());

        if (currentUser == null) {
            redirectAttributes
                    .addFlashAttribute("isExist", false)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        userService.loginUser(currentUser.getId(), currentUser.getUsername());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        //втори вариант -> currentUser = null;
        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}


