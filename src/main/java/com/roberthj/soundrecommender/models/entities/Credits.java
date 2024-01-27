package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Credits {

    @Column(name = "sound_id")
    private String soundId;

    @Column(name = "artist_id")
    private String artistId;

    @Column(name = "role")
    private String role; //TODO: Consider using enum here
}
