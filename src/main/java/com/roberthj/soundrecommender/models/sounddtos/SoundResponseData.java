package com.roberthj.soundrecommender.models.sounddtos;

import lombok.Data;

import java.util.List;

@Data
public class SoundResponseData {
    private String id;
    private String title;
    private int bpm;
    private List<String> genres;
    private int duration_in_seconds;
    private List<SoundResponseCredits> credits;
}
