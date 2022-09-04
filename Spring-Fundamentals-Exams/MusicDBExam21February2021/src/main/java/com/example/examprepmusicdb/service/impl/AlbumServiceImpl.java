package com.example.examprepmusicdb.service.impl;

import com.example.examprepmusicdb.model.entity.Album;
import com.example.examprepmusicdb.model.service.AlbumServiceModel;
import com.example.examprepmusicdb.model.view.AlbumViewModel;
import com.example.examprepmusicdb.repository.AlbumRepository;
import com.example.examprepmusicdb.service.AlbumService;
import com.example.examprepmusicdb.service.ArtistService;
import com.example.examprepmusicdb.service.UserService;
import com.example.examprepmusicdb.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.artistService = artistService;
    }


    @Override
    public void addNewOrder(AlbumServiceModel albumServiceModel) {

        Album album = this.modelMapper.map(albumServiceModel, Album.class);
        album.setAddedFrom(userService.findById(currentUser.getId()));
        album.setArtist(artistService.findByArtistName(albumServiceModel.getArtist().getName()));
        this.albumRepository.saveAndFlush(album);
    }

    @Override
    public Integer findAllAlbumsTotalSoldCopies() {
        return albumRepository.findAlbumsByTotalSoldCopies();

//        .stream().map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
//                .reduce(Integer::sum).orElse(0));
    }

    @Override
    public List<AlbumViewModel> listAllAlbums() {
        return this.albumRepository.findAll()
                .stream().map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Album> findCountOfCopiesPerAlbum(String albumsName) {
        return this.albumRepository.findAlbumByCopies(albumsName);
    }

    @Override
    public void deleteOrder(Long id) {
        this.albumRepository.deleteById(id);
    }
}
