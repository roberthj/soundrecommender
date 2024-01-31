package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Sound;

import java.util.List;

public interface SoundService {
    List<Sound> createSounds(List<Sound> sounds);

    List<Sound> getSounds();

    List<Sound> getSoundsByArtist(String artistName);
}
