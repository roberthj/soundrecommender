package com.roberthj.soundrecommender.models.sounddtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Credits {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Role is required.")
    private String role;
}
