package com.roberthj.soundrecommender.resource;

import com.roberthj.soundrecommender.models.playlistapirequests.CreatePlaylistRequest;
import com.roberthj.soundrecommender.models.playlistapiresponse.PlaylistResponse;
import com.roberthj.soundrecommender.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.roberthj.soundrecommender.utils.ObjectMappers.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;


    public PlaylistController(PlaylistService playlistService) {

        this.playlistService = playlistService;
    }
    @PostMapping(value="")
    public ResponseEntity<PlaylistResponse> createPlaylist(@RequestBody
    final CreatePlaylistRequest createPlaylistRequest){

        var createdPlaylist = playlistService.createPlaylist(mapCreatePlaylistRequestToPlaylist(createPlaylistRequest));

        return ResponseEntity.status(HttpStatus.OK).body(mapPlaylistToPlaylistResponse(List.of(createdPlaylist)));

    }
}
