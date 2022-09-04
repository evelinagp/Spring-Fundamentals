package com.example.examprepmusicdb.model.entity;

import com.example.examprepmusicdb.model.entity.enums.GenreNameEnum;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{
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

    public Album() {
    }
    @Column( nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column( nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column( nullable = false, columnDefinition = "TEXT")
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

    @Column( nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }
    @Enumerated(EnumType.ORDINAL)
    public GenreNameEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreNameEnum genre) {
        this.genre = genre;
    }
    @Positive
    @Column( nullable = false)
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
    @ManyToOne(optional = false)
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    @ManyToOne(optional = false)
    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
