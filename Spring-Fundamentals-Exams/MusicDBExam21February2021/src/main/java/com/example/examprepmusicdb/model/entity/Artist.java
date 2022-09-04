package com.example.examprepmusicdb.model.entity;

import com.example.examprepmusicdb.model.entity.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {
    private ArtistNameEnum name;
    private String careerInformation;

    public Artist() {
    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }
    @Column(columnDefinition = "TEXT", name = "carrer_information")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
