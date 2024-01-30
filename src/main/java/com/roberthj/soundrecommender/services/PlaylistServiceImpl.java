package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Playlist;
import com.roberthj.soundrecommender.repositories.PlaylistsRepository;
import com.roberthj.soundrecommender.repositories.PlaylistsSoundsRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
  private final PlaylistsRepository playlistsRepository;
  private final PlaylistsSoundsRepository playlistsSoundsRepository;

  public PlaylistServiceImpl(
      PlaylistsRepository playlistsRepository,
      PlaylistsSoundsRepository playlistsSoundsRepository) {
    this.playlistsRepository = playlistsRepository;
    this.playlistsSoundsRepository = playlistsSoundsRepository;
  }

  @Transactional
  public List<Playlist> createPlaylists(List<Playlist> playlist) {

    return playlist.stream().map(this::createPlaylist).toList();
  }

  private Playlist createPlaylist(Playlist playlist) {

    var soundIds = playlist.getSoundIds();

    Playlist createdPlaylist = null;
    try {

      var created = playlistsRepository.save(playlist);

      //TODO: Can Improve this?
      created.setSoundIds(
          soundIds.stream()
              .map(
                  soundId -> {
                    soundId.setPlaylistId(created.getId());
                    playlistsSoundsRepository.save(soundId);
                    return soundId;
                  })
              .toList());

      createdPlaylist = created;

    } catch (DataIntegrityViolationException e) {
      // TODO: What other exceptions?
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    return createdPlaylist;
  }
}
