package com.roberthj.soundrecommender.models.soundapirequests;

import java.util.List;

@lombok.Data
public class CreateSoundRequestData {
    private String title;
    private int bpm;
    private List<String> genres;
    private int duration_in_seconds;
    private List<Credits> credits;
}
