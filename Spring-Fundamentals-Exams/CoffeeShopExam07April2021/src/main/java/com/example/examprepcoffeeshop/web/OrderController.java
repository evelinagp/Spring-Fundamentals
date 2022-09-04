package com.example.examprepcoffeeshop.web;

import com.example.examprepcoffeeshop.model.binding.OrderAddBindingModel;
import com.example.examprepcoffeeshop.model.service.OrderServiceModel;
import com.example.examprepcoffeeshop.service.OrderService;
import com.example.examprepcoffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final OrderService orderService;

    public OrderController(CurrentUser currentUser, ModelMapper modelMapper, OrderService orderService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OrderAddBindingModel orderAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
            return "redirect:add";
        }

        orderService.addNewOrder(modelMapper.map(orderAddBindingModel, OrderServiceModel.class));

        return "redirect:/";
    }
    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id) {
        orderService.readyOrder(id);
        return "redirect:/";
    }

    @ModelAttribute
    public OrderAddBindingModel routeAddBindingModel() {
        return new OrderAddBindingModel();
    }
}
