package com.roberthj.soundrecommender.models.sounddtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateSoundRequestData {
    @NotBlank(message = "Title is required.")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "Bpm is required.")
    @JsonProperty("bpm")
    private int bpm;

    @NotEmpty(message = "Genres is required.")
    @JsonProperty("genres")
    private List<String> genres;

    @NotNull(message = "Bpm is required.")
    @JsonProperty("duration_in_seconds")
    private int duration_in_seconds;

    @Valid
    @NotEmpty(message = "Credits is required.")
    @JsonProperty("credits")
    private List<CreateSoundRequestCredits> credits;
}
