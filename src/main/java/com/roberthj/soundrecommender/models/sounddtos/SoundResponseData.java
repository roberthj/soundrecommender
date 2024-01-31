package com.roberthj.soundrecommender.models.sounddtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SoundResponseData {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("bpm")
    private int bpm;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("duration_in_seconds")
    private int duration_in_seconds;
    @JsonProperty("credits")
    private List<SoundResponseCredits> credits;
}
