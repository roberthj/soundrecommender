package com.roberthj.soundrecommender.models.apirequests;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Data {
    private String title;
    private int bpm;
    private List<String> genres;
    private int duration_in_seconds;
    private List<Credits> credits;
}
