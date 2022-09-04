package com.example.examprepmusicdb.model.service;

import com.example.examprepmusicdb.model.entity.Artist;
import com.example.examprepmusicdb.model.entity.User;
import com.example.examprepmusicdb.model.entity.enums.GenreNameEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel {
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private String producer;
    private Integer copies;
    private GenreNameEnum genre;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Artist artist;
    private User addedFrom;

    public AlbumServiceModel() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
