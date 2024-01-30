package com.roberthj.soundrecommender.models.playlistdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CreatePlaylistRequest {

    @Valid
    @NotEmpty(message="Data is required")
    @JsonProperty("data")
    private List<PlaylistData> data;
}
