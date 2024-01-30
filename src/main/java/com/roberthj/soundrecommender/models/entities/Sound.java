package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sound_id")
    private List<Credit> credits;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sound_id")
    private List<Genre> genres;
}
