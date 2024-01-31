package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Playlist;
import com.roberthj.soundrecommender.repositories.PlaylistsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
  private final PlaylistsRepository playlistsRepository;

  public PlaylistServiceImpl(PlaylistsRepository playlistsRepository) {
    this.playlistsRepository = playlistsRepository;
  }

  @Transactional
  public List<Playlist> createPlaylists(List<Playlist> playlist) {

    return playlist.stream().map(this::createPlaylist).toList();
  }


  private Playlist createPlaylist(Playlist playlist) {

    var soundIds = playlist.getSoundIds();

    // Connecting the child so hibernate can update the ids correctly after save
    soundIds.forEach(soundId -> soundId.setPlaylist(playlist));

      return playlistsRepository.save(playlist);
  }
}
