package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Playlist;
import com.roberthj.soundrecommender.models.entities.PlaylistSound;
import com.roberthj.soundrecommender.repositories.PlaylistsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaylistServiceImplTest {

  @Mock PlaylistsRepository playlistsRepository;

  @InjectMocks PlaylistServiceImpl playlistService;

  @Test
  public void createPlaylistsShouldReturnListOfPlayListsIncludingPlaylistIds() throws IOException {

    var playlistFromRequest = mockedPlaylist(null);
    when(playlistsRepository.save(playlistFromRequest)).thenReturn(mockedPlaylist("playlistId"));

    var expectedResult = List.of(mockedPlaylist("playlistId"));
    var result = playlistService.createPlaylists(List.of(playlistFromRequest));

    assertEquals(expectedResult, result);
  }

  private Playlist mockedPlaylist(String playlistId) {

    var playlistSound = new PlaylistSound();
    playlistSound.setSoundId("soundId");

    var playlist = new Playlist();
    playlist.setTitle("title");
    playlist.setSoundIds(List.of(playlistSound));

    if (playlistId != null) {
      playlist.setId(playlistId);
    }

    return playlist;
  }
}
