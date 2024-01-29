package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Playlist;
import com.roberthj.soundrecommender.models.entities.PlaylistSound;
import com.roberthj.soundrecommender.repository.PlaylistsDAO;
import com.roberthj.soundrecommender.repository.PlaylistsSoundsDAO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaylistService {
  private final PlaylistsDAO playlistDAO;
  private final PlaylistsSoundsDAO playlistsSoundsDAO;

  public PlaylistService(PlaylistsDAO playlistDAO, PlaylistsSoundsDAO playlistsSoundsDAO) {
    this.playlistDAO = playlistDAO;
    this.playlistsSoundsDAO = playlistsSoundsDAO;
  }

  @Transactional
  public Playlist createPlaylist(Playlist playlist) {

    var soundIds = playlist.getSoundIds();

    Playlist createdPlaylist = null;
    try {

      var created = playlistDAO.save(playlist);

      soundIds.forEach(
          soundId -> {
            soundId.setPlaylistId(created.getId());
            playlistsSoundsDAO.save(soundId);
          });

      createdPlaylist = created;

    } catch (DataIntegrityViolationException e) {
      //TODO: What other exceptions?
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    return createdPlaylist;
  }
}
