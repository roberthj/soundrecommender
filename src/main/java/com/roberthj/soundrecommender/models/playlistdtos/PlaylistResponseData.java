package com.roberthj.soundrecommender.models.playlistdtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistResponseData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("sounds")
    private List<String> soundIds;
}
