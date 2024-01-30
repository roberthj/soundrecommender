//package com.roberthj.soundrecommender.services;
//
//import com.roberthj.soundrecommender.models.entities.Playlist;
//import com.roberthj.soundrecommender.models.entities.PlaylistSound;
//import com.roberthj.soundrecommender.repositories.PlaylistsRepository;
//import com.roberthj.soundrecommender.repositories.PlaylistsSoundsRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class PlaylistServiceImplTest {
//
//    @Mock
//    PlaylistsRepository playlistsRepository;
//
//    @Mock
//    PlaylistsSoundsRepository playlistsSoundsRepository;
//
//    @InjectMocks PlaylistServiceImpl playlistService;
//
//    @Test
//    public void createPlaylistsShouldReturnListOfPlayListsIncludingPlaylistIds() throws IOException {
//
//        var playlistFromRequest = mockedPlaylist(null);
//        when(playlistsRepository.save(playlistFromRequest)).thenReturn(mockedRepositoryPlaylist());
//        when(playlistsSoundsRepository.save(playlistFromRequest.getSoundIds().get(0))).thenReturn(mockedRepositoryPlaylistSound());
//
//        var expectedResult = List.of(mockedPlaylist("playlistId"));
//        var result = playlistService.createPlaylists(List.of(playlistFromRequest));
//
//        assertEquals(expectedResult,result);
//    }
//
//    private Playlist mockedPlaylist(String playlistId) {
//
//        var playlistSound = new PlaylistSound();
//        playlistSound.setSoundId("soundId");
//
//        var playlist = new Playlist();
//        playlist.setTitle("title");
//        playlist.setSoundIds(List.of(playlistSound));
//
//        if(playlistId != null) {
//            playlistSound.setPlaylistId(playlistId);
//            playlist.setId(playlistId);
//        }
//
//
//        return playlist;
//    }
//
//    private Playlist mockedRepositoryPlaylist() {
//
//        var playlist = new Playlist();
//        playlist.setId("playlistId");
//        playlist.setTitle("title");
//
//
//        return playlist;
//
//    }
//
//    private PlaylistSound mockedRepositoryPlaylistSound(){
//        var playlistSound = new PlaylistSound();
//        playlistSound.setPlaylistId("playlistId");
//        playlistSound.setSoundId("soundId");
//
//        return playlistSound;
//    }
//
//
//}
