package com.roberthj.soundrecommender.controllers;

import com.roberthj.soundrecommender.models.entities.Playlist;
import com.roberthj.soundrecommender.models.entities.PlaylistSound;
import com.roberthj.soundrecommender.services.PlaylistService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PlaylistController.class)
class PlaylistControllerTest {
  @Autowired MockMvc mvc;
  @MockBean PlaylistService playlistService;

  @Test
  public void createPlaylistReturnCorrectJson() throws Exception {

    var requestBody =
        "{\n"
            + "    \"data\":\n"
            + "    [\n"
            + "        {\n"
            + "            \"title\": \"Title\",\n"
            + "            \"sounds\": [\"soundId\"]\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    when(playlistService.createPlaylists(List.of(mockedPlaylist(null))))
        .thenReturn(List.of(mockedPlaylist("id")));

    mvc.perform(post("/playlists").content(requestBody).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data").exists())
        .andExpect(jsonPath("$.data").isArray())
        .andExpect(jsonPath("$.data").isNotEmpty())
        .andExpect(jsonPath("$.data[0].id").exists())
        .andExpect(jsonPath("$.data[0].id").value("id"));
  }

  @Disabled("Test to implemented")
  @Test
  public void verifyThatCreatePlaylistsReturnsBadRequestWhenSaveToDbThrowsDataIntegrityViolationException(){

  }

  private Playlist mockedPlaylist(String id) {

    var playlistSound = new PlaylistSound();
    playlistSound.setSoundId("soundId");

    var playlist = new Playlist();
    playlist.setTitle("Title");
    playlist.setSoundIds(List.of(playlistSound));

    if (id != null) {
      playlist.setId(id);
    }

    return playlist;
  }
}
