package com.roberthj.soundrecommender.models.sounddtos;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@Data
public class SoundResponse {
    @JsonProperty("data")
    public List<SoundResponseData> data;


}
