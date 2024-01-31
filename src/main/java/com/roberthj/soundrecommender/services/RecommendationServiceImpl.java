package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Credit;
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

        // get all sounds in playlist
        var soundsInPlaylist =
                soundRepository.findSongsFromPlaylist(playlistId);

        // Collect all artists
        var artistsInPlaylist =
                soundsInPlaylist
                        .stream()
                        .flatMap(sound -> {
                           return sound.getCredits()
                                    .stream()
                                    .map(Credit::getName);
                        })
                        .distinct()
                        .toList();

        // Find all songs by the artists
        var soundsByArtist = soundRepository.findSongsByArtist(artistsInPlaylist).stream().distinct().toList();

        //Songs that were already in the provided playlist
        var soundIdsInPlaylist =
                soundsInPlaylist.stream().map(Sound::getId).distinct().toList();

        // Return recommended songs, excluding the ones already in the provided playlist
        return soundsByArtist
                .stream()
                .filter(sound -> !soundIdsInPlaylist.contains(sound.getId()))
                        .toList();
    }
}
