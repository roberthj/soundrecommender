package com.roberthj.soundrecommender.resource;

import com.roberthj.soundrecommender.models.apirequests.CreateSoundPayload;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.service.SoundRecommenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/v1") //I wanted to add versioning here, but did not want to break the postman tests
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

        //Validate payload

        //Map to entity

        //Pass entity to service

      var tmp = soundRecommenderService.createSound(mapToEntity(createSoundPayload));



        return null;
  }


  private Sound mapToEntity(CreateSoundPayload createSoundPayload) {
      var data = createSoundPayload.getData();


        return  Sound.builder()
                        .title(data.get(0).getTitle())
                        .bpm(data.get(0).getBpm())
                        .durationInSeconds(data.get(0).getDuration_in_seconds()).build();

  }
}
