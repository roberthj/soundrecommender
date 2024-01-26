package com.roberthj.soundrecommender.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/v1")
public class SoundRecommenderController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello!";
    }

}
