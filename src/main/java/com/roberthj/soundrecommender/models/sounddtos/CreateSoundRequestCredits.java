package com.roberthj.soundrecommender.models.sounddtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateSoundRequestCredits {

    @NotBlank(message = "Name is required.")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "Role is required.")
    @JsonProperty("role")
    private String role;
}
