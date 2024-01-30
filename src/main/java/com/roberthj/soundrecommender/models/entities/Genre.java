package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    //@Column(name = "sound_id")
    //private String soundId;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    private Sound sound;

}
