package com.roberthj.soundrecommender.models.playlistdtos;

import lombok.Data;

import java.util.List;

@Data
public class PlaylistResponseData {

    private String id;

    private String title;

    private List<String> soundIds;
}
