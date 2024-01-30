package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaylistService {

    List<Playlist> createPlaylists(List<Playlist> playlist);
}
