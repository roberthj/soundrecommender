package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repositories.CreditsRepository;
import com.roberthj.soundrecommender.repositories.GenresRepository;
import com.roberthj.soundrecommender.repositories.SoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoundServiceImpl implements SoundService {

  private final SoundRepository soundRepository;
  private final CreditsRepository creditsRepository;
  private final GenresRepository genresRepository;

  public SoundServiceImpl(
      SoundRepository soundRepository,
      CreditsRepository creditsRepository,
      GenresRepository genresRepository) {
    this.soundRepository = soundRepository;
    this.creditsRepository = creditsRepository;
    this.genresRepository = genresRepository;
  }
  @Transactional
  public List<Sound> createSounds(List<Sound> sounds) {

     return sounds
             .stream()
             .map(this::createSound)
             .toList();

  }

  public List<Sound> getSounds() {

    return soundRepository.findAll();
  }

  private Sound createSound(Sound sound) {

      var credits = sound.getCredits();
      var genres = sound.getGenres();

      var created = soundRepository.save(sound);

      credits.forEach(
              credit -> {
                  credit.setSoundId(created.getId());
                  creditsRepository.save(credit);
              });

      genres.forEach(
              genre -> {
                  genre.setSoundId(created.getId());
                  genresRepository.save(genre);
              });
      return sound;
  }
}
