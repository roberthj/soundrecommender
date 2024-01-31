package com.roberthj.soundrecommender.controllers;

import com.roberthj.soundrecommender.models.sounddtos.CreateSoundRequest;
import com.roberthj.soundrecommender.models.sounddtos.SoundResponse;
import com.roberthj.soundrecommender.services.RecommendationService;
import com.roberthj.soundrecommender.services.SoundService;
import com.roberthj.soundrecommender.services.SoundServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static com.roberthj.soundrecommender.utils.ObjectMappers.mapCreateSoundRequestToSounds;
import static com.roberthj.soundrecommender.utils.ObjectMappers.mapSoundToSoundResponse;
@RestController
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
      @Valid @RequestBody final CreateSoundRequest createSoundRequest) {

    try {
      var createdSound =
          soundService.createSounds((mapCreateSoundRequestToSounds(createSoundRequest)));

      return ResponseEntity.status(HttpStatus.CREATED).body(mapSoundToSoundResponse(createdSound));

    } catch (DataIntegrityViolationException e) {
      // I could not catch this in the service class already singe the transaction was not completed when the exception occurred

      System.out.println(
              String.format(
                      "Error saving sound: %s", e.getMessage()));
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }
  }

  @GetMapping(value = "/sounds")
  public ResponseEntity<SoundResponse> getSounds() {

    return ResponseEntity.status(HttpStatus.OK)
        .body(mapSoundToSoundResponse(soundService.getSounds()));
  }

  @GetMapping(value = "/sounds/recommended")
  public ResponseEntity<SoundResponse> recommendSounds(@RequestParam String playlistId) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(mapSoundToSoundResponse(recommendationService.getRecommendations(playlistId)));
  }
}
