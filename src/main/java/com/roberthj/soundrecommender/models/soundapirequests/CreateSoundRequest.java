package com.roberthj.soundrecommender.models.soundapirequests;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;

@Data
public class CreateSoundRequest {
    @JsonProperty("data")
    private ArrayList<CreateSoundRequestData> data;

}