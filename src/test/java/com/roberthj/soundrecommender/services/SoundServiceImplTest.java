package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repositories.SoundRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SoundServiceImplTest {

  @Mock SoundRepository soundRepository;

  @InjectMocks SoundServiceImpl soundService;

  @Test
  public void createSoundsShouldReturnListOfSoundsIncludingPlaylistIds() throws IOException {

    var soundsFromRequest = mockedSound(null);
    when(soundRepository.save(soundsFromRequest)).thenReturn(mockedSound("soundId"));

    var expectedResult = List.of(mockedSound("soundId"));
    var result = soundService.createSounds(List.of(soundsFromRequest));

    assertEquals(expectedResult, result);
  }

  @Test
  public void getSoundsShouldReturnListOfSounds(){

    //No logic to test, but testing that soundRepository.findAll() is called
    when(soundRepository.findAll()).thenReturn(List.of(mockedSound("soundId")));

    var result = soundService.getSounds();

    var expectedResult = List.of(mockedSound("soundId"));

    assertEquals(expectedResult, result);

  }



  private Sound mockedSound(String soundId) {

    var genre = new Genre();
    genre.setGenre("genre");

    var credit = new Credit();
    credit.setName("artist_name");
    credit.setRole("role");

    var sound = new Sound();
    sound.setTitle("title");
    sound.setBpm(120);
    sound.setDurationInSeconds(160);
    sound.setGenres(List.of(genre));
    sound.setCredits(List.of(credit));

    return sound;
  }
}
