package com.roberthj.soundrecommender.controllers;

import com.roberthj.soundrecommender.models.playlistdtos.CreatePlaylistRequest;
import com.roberthj.soundrecommender.models.playlistdtos.PlaylistResponse;
import com.roberthj.soundrecommender.services.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

        try {
            var createdPlaylist = playlistService.createPlaylists(mapCreatePlaylistRequestToPlaylist(createPlaylistRequest));

            return ResponseEntity.status(HttpStatus.OK).body(mapPlaylistToPlaylistResponse(createdPlaylist));

        } catch (DataIntegrityViolationException e) {
            // I could not catch this in the service class already singe the transaction was not completed when the exception occurred
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }

}
