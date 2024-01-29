package com.roberthj.soundrecommender.models.playlistapirequests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistData {
    @JsonProperty("title")
    private String title;

    @JsonProperty("sounds")
    private List<String> sounds;
}
