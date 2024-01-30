package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repositories.SoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    private final SoundRepository soundRepository;

    public RecommendationServiceImpl(SoundRepository soundRepository) {

        this.soundRepository = soundRepository;
    }

    public List<Sound> getRecommendations(String playlistId) {


        var soundsInPlaylist =
                soundRepository.findSongsFromPlaylist(playlistId);

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


        var soundsByArtist = soundRepository.findSongsByArtist(artistsInPlaylist);

        //Exclude the songs in the playlist
        var soundIdsInPlaylist =
                soundsInPlaylist.stream().map(Sound::getId).toList();

        return soundsByArtist
                .stream()
                .filter(sound -> !soundIdsInPlaylist.contains(sound.getId()))
                        .toList();

    }
}
