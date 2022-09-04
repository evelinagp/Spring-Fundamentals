package com.example.examprepshoppinglist.web;


import com.example.examprepshoppinglist.model.binding.ProductAddBindingModel;
import com.example.examprepshoppinglist.model.service.ProductServiceModel;
import com.example.examprepshoppinglist.service.ProductService;
import com.example.examprepshoppinglist.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final CurrentUser currentUser;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(CurrentUser currentUser, ProductService productService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }

        productService.addNewProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id) {
        productService.buyById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        productService.buyAll();
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}

