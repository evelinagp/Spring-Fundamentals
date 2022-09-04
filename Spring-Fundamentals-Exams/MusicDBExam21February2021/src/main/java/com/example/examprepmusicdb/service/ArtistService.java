package com.example.examprepmusicdb.service;

import com.example.examprepmusicdb.model.entity.Artist;
import com.example.examprepmusicdb.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();

    Artist findById(Long id);

    Artist findByArtistName(ArtistNameEnum artistNameEnum);
}
