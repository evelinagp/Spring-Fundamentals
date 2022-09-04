package com.example.examprepmusicdb.service;

import com.example.examprepmusicdb.model.entity.Album;
import com.example.examprepmusicdb.model.service.AlbumServiceModel;
import com.example.examprepmusicdb.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addNewOrder(AlbumServiceModel albumServiceModel);

    Integer findAllAlbumsTotalSoldCopies();

    List<AlbumViewModel> listAllAlbums();

    List<Album> findCountOfCopiesPerAlbum(String albumName);

    void deleteOrder(Long id);
}
