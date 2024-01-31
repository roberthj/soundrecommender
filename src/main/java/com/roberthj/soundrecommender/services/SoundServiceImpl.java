package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repositories.SoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoundServiceImpl implements SoundService {

  private final SoundRepository soundRepository;

  public SoundServiceImpl(SoundRepository soundRepository) {
    this.soundRepository = soundRepository;
  }

  @Transactional
  public List<Sound> createSounds(List<Sound> sounds) {

    return sounds.stream().map(this::createSound).toList();
  }

  public List<Sound> getSounds() {

    return soundRepository.findAll();
  }

  public List<Sound> getSoundsByArtist(String artistName) {

    return soundRepository.findSoundsByArtist(artistName).stream().distinct().toList();
  }

  private Sound createSound(Sound sound) {

    // Connecting the children so hibernate can update the ids correctly after save
    var credits = sound.getCredits();
    var genres = sound.getGenres();
    genres.forEach(genre -> genre.setSound(sound));

    credits.forEach(credit -> credit.setSound(sound));

    System.out.println(
            String.format(
                    "Saving sound %s ", sound.getTitle()));

    return soundRepository.save(sound);
  }
}
