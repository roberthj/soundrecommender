package com.roberthj.soundrecommender.models.playlistdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistData {

    @NotBlank(message = "Title is required.")
    @JsonProperty("title")
    private String title;

    @NotEmpty
    @JsonProperty("sounds")
    private List<String> sounds;
}
