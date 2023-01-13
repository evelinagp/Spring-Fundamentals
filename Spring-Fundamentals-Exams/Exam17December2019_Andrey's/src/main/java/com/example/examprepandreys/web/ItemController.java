package com.example.examprepandreys.web;


import com.example.examprepandreys.model.binding.ItemAddBindingModel;
import com.example.examprepandreys.model.service.ItemServiceModel;
import com.example.examprepandreys.service.ItemService;
import com.example.examprepandreys.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final CurrentUser currentUser;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(CurrentUser currentUser, ItemService itemService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }

        itemService.addNewItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("item", this.itemService.findItemById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }

    @Transactional
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        this.itemService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel() {
        return new ItemAddBindingModel();
    }
}

