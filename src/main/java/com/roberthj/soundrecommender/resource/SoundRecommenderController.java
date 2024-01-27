package com.roberthj.soundrecommender.resource;

import com.roberthj.soundrecommender.models.apirequests.CreateSoundPayload;
import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.service.SoundRecommenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
// @RequestMapping("/v1") //I wanted to add versioning here, but did not want to break the postman
// tests
@RequestMapping("")
public class SoundRecommenderController {

  private final SoundRecommenderService soundRecommenderService;

  public SoundRecommenderController(SoundRecommenderService soundRecommenderService) {
    this.soundRecommenderService = soundRecommenderService;
  }

  @GetMapping("/hello")
  public String hello() {

    return "Hello!";
  }

  @PostMapping(value = "/admin/sounds")
  public ResponseEntity<String> createSound(
      @RequestBody final CreateSoundPayload createSoundPayload) {

    // Validate payload

    // Map to entity

    // Pass entity to service

    var tmp = soundRecommenderService.createSound(mapToEntity(createSoundPayload));

    return null;
  }

  private Sound mapToEntity(CreateSoundPayload createSoundPayload) {
    var data = createSoundPayload.getData();
    var cred = data.get(0).getCredits();
    var gen = data.get(0).getGenres();

    // TODO: fix these get(0)

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
}
