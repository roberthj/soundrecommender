package com.roberthj.soundrecommender.models.sounddtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
public class CreateSoundRequest {

    @Valid
    @NotEmpty(message="Data is required")
    @JsonProperty("data")
    private List<CreateSoundRequestData> data;

}