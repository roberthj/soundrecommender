package com.roberthj.soundrecommender.utils;

import com.roberthj.soundrecommender.models.apirequests.CreateSoundRequest;
import com.roberthj.soundrecommender.models.apirequests.Credits;
import com.roberthj.soundrecommender.models.apiresponses.Data;
import com.roberthj.soundrecommender.models.apiresponses.SoundResponse;
import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMappers {
  public static Sound mapCreateSoundRequestToSound(CreateSoundRequest createSoundRequest) {
    var data = createSoundRequest.getData();
    var cred = data.get(0).getCredits();
    var gen = data.get(0).getGenres();

    // TODO: fix these get(0)
    // Try ModelMapper

    var genres =
        gen.stream()
            .map(
                g -> {
                  var genre = new Genre();
                  genre.setGenre(g);
                  return genre;
                })
            .collect(Collectors.toList());

    var credits =
        cred.stream()
            .map(
                c -> {
                  var credit = new Credit();
                  credit.setRole(c.getRole());
                  credit.setName(c.getName());
                  return credit;
                })
            .collect(Collectors.toList());

    var sound = new Sound();

    sound.setTitle(data.get(0).getTitle());
    sound.setBpm(data.get(0).getBpm());
    sound.setDurationInSeconds(data.get(0).getDuration_in_seconds());
    sound.setGenres(genres);
    sound.setCredits(credits);

    return sound;
  }

  public static SoundResponse mapSoundToSoundResponse(List<Sound> sounds) {

    var data = sounds.stream().map(ObjectMappers::mapSoundToData).toList();
    var soundResponse = new SoundResponse();

    soundResponse.setData(data);

    return soundResponse;
  }

  private static Data mapSoundToData(Sound sound) {

    var credits =
        sound.getCredits().stream()
            .map(
                cred -> {
                  var cre = new Credits();
                  cre.setName(cred.getName());
                  cre.setRole(cred.getRole());
                  return cre;
                })
            .collect(Collectors.toList());

    var genres = sound.getGenres().stream().map(Genre::getGenre).collect(Collectors.toList());

    Data data = new Data();

    data.setId(sound.getId());
    data.setTitle(sound.getTitle());
    data.setBpm(sound.getBpm());
    data.setDuration_in_seconds(sound.getDurationInSeconds());
    data.setGenres(genres);
    data.setCredits(credits);

    return data;
  }
}
