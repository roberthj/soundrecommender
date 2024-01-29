package com.roberthj.soundrecommender.models.playlistapirequests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreatePlaylistRequest {
    @JsonProperty("data")
    private List<PlaylistData> data;
}
