package com.example.examprepmusicdb.model.binding;

import com.example.examprepmusicdb.model.entity.Artist;
import com.example.examprepmusicdb.model.entity.User;
import com.example.examprepmusicdb.model.entity.enums.ArtistNameEnum;
import com.example.examprepmusicdb.model.entity.enums.GenreNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistNameEnum artist;
    private GenreNameEnum genre;
    private String description;

    public AlbumAddBindingModel() {
    }
    @NotBlank(message = "Name can not be empty string.")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotBlank(message = "Image Url can not be empty string.")
    @Size(min = 5, message = "Image Url length must be minimum 5(inclusive) characters.")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotBlank(message = "Description can not be empty string.")
    @Size(min = 5, message = "Description length must be minimum 5(inclusive) characters.")
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
    @NotNull(message = "Copies can not be empty field.")
    @Positive(message = "Copies must be a more than 10(inclusive).")
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }
    //@Enumerated(EnumType.ORDINAL)
    @NotNull
    public GenreNameEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreNameEnum genre) {
        this.genre = genre;
    }
    @NotNull(message = "Price can not be empty field.")
    @Positive(message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @NotNull(message = "Date can not be empty field.")
    @PastOrPresent(message = "Date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    @NotNull
    public ArtistNameEnum getArtist() {
        return artist;
    }

    public void setArtist(ArtistNameEnum artist) {
        this.artist = artist;
    }

}
