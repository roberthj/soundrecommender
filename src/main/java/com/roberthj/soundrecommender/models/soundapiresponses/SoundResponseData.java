package com.roberthj.soundrecommender.models.soundapiresponses;

import com.roberthj.soundrecommender.models.soundapirequests.Credits;

import java.util.List;

@lombok.Data
public class SoundResponseData {
    private String id;
    private String title;
    private int bpm;
    private List<String> genres;
    private int duration_in_seconds;
    private List<Credits> credits;
}
