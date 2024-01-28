package com.roberthj.soundrecommender.resource;

import com.roberthj.soundrecommender.models.apirequests.CreateSoundRequest;
import com.roberthj.soundrecommender.models.apiresponses.SoundResponse;
import com.roberthj.soundrecommender.service.SoundRecommenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.roberthj.soundrecommender.utils.ObjectMappers.mapCreateSoundRequestToSound;
import static com.roberthj.soundrecommender.utils.ObjectMappers.mapSoundToSoundResponse;

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
  public ResponseEntity<SoundResponse> createSound(
      @RequestBody final CreateSoundRequest createSoundRequest) {

    // Validate payload
    // Try Alex's validation framework

    var createdSound =
        soundRecommenderService.createSound(mapCreateSoundRequestToSound(createSoundRequest));

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapSoundToSoundResponse(List.of(createdSound)));
  }

  @GetMapping(value = "/sounds")
  public ResponseEntity<SoundResponse> getSounds() {

    // Validate payload
    // Try Alex's validation framework

    var sounds = soundRecommenderService.getSounds();

    return ResponseEntity.status(HttpStatus.OK).body(mapSoundToSoundResponse(sounds));
  }
}
