package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Playlist;

import java.util.List;

public interface PlaylistService {

    List<Playlist> createPlaylists(List<Playlist> playlist);

}
