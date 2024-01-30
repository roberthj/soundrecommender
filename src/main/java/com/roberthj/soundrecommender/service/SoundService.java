package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Sound;

import java.util.List;

public interface SoundService {
    List<Sound> createSounds(List<Sound> sounds);

    List<Sound> getSounds();
}
