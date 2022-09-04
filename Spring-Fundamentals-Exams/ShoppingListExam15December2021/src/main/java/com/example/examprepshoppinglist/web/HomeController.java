package com.example.examprepshoppinglist.web;

import com.example.examprepshoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.examprepshoppinglist.service.ProductService;
import com.example.examprepshoppinglist.service.UserService;
import com.example.examprepshoppinglist.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ProductService productService, UserService userService) {
        this.currentUser = currentUser;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        //Втори вариант
//        public String index(HttpSession httpSession) {
//            return httpSession.getAttribute("user") == null
//                    ? "index" : "home";
//        }
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.checkProductsSum());

        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryNameEnum.DRINK));
        model.addAttribute("foods", productService
                .findAllProductsByCategoryName(CategoryNameEnum.FOOD));
        model.addAttribute("households", productService
                .findAllProductsByCategoryName(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("others", productService
                .findAllProductsByCategoryName(CategoryNameEnum.OTHER));

        return "home";
    }
}
