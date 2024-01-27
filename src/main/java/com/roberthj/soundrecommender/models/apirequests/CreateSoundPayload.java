package com.roberthj.soundrecommender.models.apirequests;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CreateSoundPayload {

    public ArrayList<Data> data;

}