package com.example.examprepandreys.web;


import com.example.examprepandreys.model.entity.enums.CategoryNameEnum;
import com.example.examprepandreys.model.view.ItemViewModel;
import com.example.examprepandreys.service.ItemService;
import com.example.examprepandreys.service.UserService;
import com.example.examprepandreys.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ItemService itemService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ItemService itemService, UserService userService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
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

        //int itemsCount = itemService.findAllItemsCount();
        List<ItemViewModel> itemsList = this.itemService.findAllItems();

        model.addAttribute("itemsCount", itemsList.size());
        model.addAttribute("itemsList", itemsList);


        return "home";
//        model.addAttribute("shirts", itemService
//                .findAllItems(CategoryNameEnum.SHIRT));
//        model.addAttribute("denims", itemService
//                .findAllItems(CategoryNameEnum.DENIM));
//        model.addAttribute("shorts", itemService
//                .findAllItems(CategoryNameEnum.SHORTS));
//        model.addAttribute("jackets", itemService
//                .findAllItems(CategoryNameEnum.JACKET));

    }
}
