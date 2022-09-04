package com.example.examprepmusicdb.model.view;

import com.example.examprepmusicdb.model.entity.Artist;
import com.example.examprepmusicdb.model.entity.User;
import com.example.examprepmusicdb.model.entity.enums.GenreNameEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private Artist artist;
    private GenreNameEnum genre;
    private BigDecimal price;
    private LocalDate releaseDate;

    private Integer copies;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public GenreNameEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreNameEnum genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }
}
