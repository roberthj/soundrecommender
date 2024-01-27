package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "sound_id")
    private String soundId;
    @Column(name = "genre")
    private String genre;

}
