package com.roberthj.soundrecommender.models.sounddtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateSoundRequestData {
    @NotBlank(message = "Title is required.")
    private String title;

    @NotNull(message = "Bpm is required.")
    private int bpm;

    @NotEmpty(message = "Genres is required.")
    private List<String> genres;

    @NotNull(message = "Bpm is required.")
    private int duration_in_seconds;

    @Valid
    @NotEmpty(message = "Credits is required.")
    private List<CreateSoundRequestCredits> credits;
}
