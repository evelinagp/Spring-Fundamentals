package com.example.examprepmusicdb.web;

import com.example.examprepmusicdb.model.entity.Album;
import com.example.examprepmusicdb.model.view.AlbumViewModel;
import com.example.examprepmusicdb.repository.AlbumRepository;
import com.example.examprepmusicdb.service.AlbumService;
import com.example.examprepmusicdb.service.UserService;
import com.example.examprepmusicdb.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;
    private final AlbumRepository albumRepository;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, AlbumService albumService, AlbumRepository albumRepository, UserService userService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
        this.albumRepository = albumRepository;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        int albumsCount = albumService.findAllAlbumsTotalSoldCopies();
        List<AlbumViewModel> albumsList = albumService.listAllAlbums().stream().sorted((a, b) -> b.getCopies().compareTo(a.getCopies())).collect(Collectors.toList());

        model.addAttribute("albumsCount", albumsCount);
        model.addAttribute("albumsList", albumsList);

        return "home";
    }
}
