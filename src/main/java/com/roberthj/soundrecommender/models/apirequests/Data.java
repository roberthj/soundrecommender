package com.roberthj.soundrecommender.models.apirequests;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Data {
    private String title;
    private int bpm;
    private ArrayList<String> genres;
    private int duration_in_seconds;
    private ArrayList<Credits> credits;
}
