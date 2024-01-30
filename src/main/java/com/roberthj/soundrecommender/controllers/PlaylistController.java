package com.roberthj.soundrecommender.controllers;

import com.roberthj.soundrecommender.models.playlistdtos.CreatePlaylistRequest;
import com.roberthj.soundrecommender.models.playlistdtos.PlaylistResponse;
import com.roberthj.soundrecommender.services.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.roberthj.soundrecommender.utils.ObjectMappers.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;


    public PlaylistController(PlaylistService playlistService) {

        this.playlistService = playlistService;
    }
    @PostMapping(value="")
    public ResponseEntity<PlaylistResponse> createPlaylist(@Valid  @RequestBody
    final CreatePlaylistRequest createPlaylistRequest){

        var createdPlaylist = playlistService.createPlaylists(mapCreatePlaylistRequestToPlaylist(createPlaylistRequest));

        return ResponseEntity.status(HttpStatus.OK).body(mapPlaylistToPlaylistResponse(createdPlaylist));

    }
}
