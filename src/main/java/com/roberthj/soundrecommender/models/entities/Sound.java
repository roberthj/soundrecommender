package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="Sound")
@Table(name="sounds")
public class Sound {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "bpm")
    private int bpm;

    @Column(name = "duration_in_seconds")
    private int durationInSeconds;

    @OneToMany
    @JoinColumn(name="sound_id")
    private List<Credit> credits;

    @OneToMany
    @JoinColumn(name="sound_id")
    private List<Genre> genres;
}
