package com.roberthj.soundrecommender.models.sounddtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SoundResponseCredits {

    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private String role;
}
