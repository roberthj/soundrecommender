package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repository.PlaylistsDAO;
import com.roberthj.soundrecommender.repository.SoundDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    private final SoundDAO soundDAO;
    private final PlaylistsDAO playlistsDAO;

    public RecommendationService(SoundDAO soundDAO, PlaylistsDAO playlistsDAO) {
        this.soundDAO = soundDAO;
        this.playlistsDAO = playlistsDAO;
    }

    public List<Sound> getRecommendations(String playlistId) {

       // var playlist = playlistsDAO.findById(playlistId).get();

        var soundsInPlaylist =
                soundDAO.findSongsFromPlaylist(playlistId);

        //Collect genres and credits

        //Search for other songs with the same artists or genres
        var artistsInPlaylist =
                soundsInPlaylist
                        .stream()
                        .flatMap(sound -> {
                           return sound.getCredits()
                                    .stream()
                                    .map(Credit::getName);
                        }).toList();

        var genresInPlaylist = soundsInPlaylist
                .stream()
                .flatMap(sound -> {
                    return sound.getGenres()
                            .stream()
                            .map(Genre::getGenre);
                }).toList();


        var soundsByArtist =soundDAO.findSongsByArtist(artistsInPlaylist);

        //Exclude the songs in the playlist
        var soundIdsInPlaylist =
                soundsInPlaylist.stream().map(Sound::getId).toList();

        return soundsByArtist
                .stream()
                .filter(sound -> !soundIdsInPlaylist.contains(sound.getId()))
                        .toList();

    }
}
