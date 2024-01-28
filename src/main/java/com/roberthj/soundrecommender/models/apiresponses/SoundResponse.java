package com.roberthj.soundrecommender.models.apiresponses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SoundResponse {
    @JsonProperty("data")
    public List<Data> data;


}
