package com.roberthj.soundrecommender.models.entities;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SoundGenres {

    @Column(name = "sound_id")
    private String soundId;
    @Column(name = "genre_id")
    private String genreId;

}
