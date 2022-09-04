package com.example.examprepmusicdb.web;

import com.example.examprepmusicdb.model.binding.AlbumAddBindingModel;
import com.example.examprepmusicdb.model.service.AlbumServiceModel;
import com.example.examprepmusicdb.service.AlbumService;
import com.example.examprepmusicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final AlbumService albumService;

    public AlbumController(CurrentUser currentUser, ModelMapper modelMapper, AlbumService albumService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.albumService = albumService;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:add";
        }

        this.albumService.addNewOrder(this.modelMapper.map(albumAddBindingModel, AlbumServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        albumService.deleteOrder(id);
        return "redirect:/";
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel() {
        return new AlbumAddBindingModel();
    }
}
