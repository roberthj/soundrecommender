package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="sounds")
public class Sound {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "bpm")
    private int bpm;

    @Column(name = "duration_in_seconds")
    private int durationInSeconds;
}
