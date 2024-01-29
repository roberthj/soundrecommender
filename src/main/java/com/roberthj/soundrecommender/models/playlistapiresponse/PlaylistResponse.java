package com.roberthj.soundrecommender.models.playlistapiresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistResponse {

    @JsonProperty("data")
    private List<PlaylistResponseData> data;
}
