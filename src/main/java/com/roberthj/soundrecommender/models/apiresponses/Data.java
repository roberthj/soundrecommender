package com.roberthj.soundrecommender.models.apiresponses;

import com.roberthj.soundrecommender.models.apirequests.Credits;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    private String id;
    private String title;
    private int bpm;
    private List<String> genres;
    private int duration_in_seconds;
    private List<Credits> credits;
}
