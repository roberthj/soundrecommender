package com.roberthj.soundrecommender.resource;

import com.roberthj.soundrecommender.models.soundapirequests.CreateSoundRequest;
import com.roberthj.soundrecommender.models.soundapiresponses.SoundResponse;
import com.roberthj.soundrecommender.service.RecommendationService;
import com.roberthj.soundrecommender.service.SoundService;
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
public class SoundController {

  private final SoundService soundService;
  private final RecommendationService recommendationService;

  public SoundController(SoundService soundService, RecommendationService recommendationService) {
    this.soundService = soundService;
      this.recommendationService = recommendationService;
  }


  @PostMapping(value = "/admin/sounds")
  public ResponseEntity<SoundResponse> createSound(
      @RequestBody final CreateSoundRequest createSoundRequest) {

    // Validate payload
    // Try Alex's validation framework

    var createdSound =
        soundService.createSound(mapCreateSoundRequestToSound(createSoundRequest));

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapSoundToSoundResponse(List.of(createdSound)));
  }

  @GetMapping(value = "/sounds")
  public ResponseEntity<SoundResponse> getSounds() {

    // Validate payload
    // Try Alex's validation framework

    return ResponseEntity.status(HttpStatus.OK)
            .body(mapSoundToSoundResponse(soundService.getSounds()));
  }

  @GetMapping(value = "/sounds/recommended")
  public ResponseEntity<SoundResponse> recommendSounds(
          @RequestParam String playlistId) {


    return ResponseEntity.status(HttpStatus.OK)
            .body(mapSoundToSoundResponse(recommendationService.getRecommendations(playlistId)));
  }
}
