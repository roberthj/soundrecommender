package com.roberthj.soundrecommender.utils;

import com.roberthj.soundrecommender.models.entities.*;
import com.roberthj.soundrecommender.models.playlistdtos.CreatePlaylistRequest;
import com.roberthj.soundrecommender.models.playlistdtos.PlaylistResponse;
import com.roberthj.soundrecommender.models.playlistdtos.PlaylistResponseData;
import com.roberthj.soundrecommender.models.sounddtos.*;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMappers {

  public static List<Sound> mapCreateSoundRequestToSounds(CreateSoundRequest createSoundRequest) {

    var data = createSoundRequest.getData();

    return data.stream()
        .map(
            d -> {
              var sound = new Sound();

              sound.setTitle(d.getTitle());
              sound.setBpm(d.getBpm());
              sound.setDurationInSeconds(d.getDuration_in_seconds());
              sound.setGenres(mapToGenres(d.getGenres()));
              sound.setCredits(mapToCredits(d.getCredits()));
              return sound;
            })
        .toList();
  }

  private static List<Credit> mapToCredits(List<CreateSoundRequestCredits> credits) {
    return credits.stream()
        .map(
            c -> {
              var credit = new Credit();
              credit.setRole(c.getRole());
              credit.setName(c.getName());
              return credit;
            })
        .toList();
  }

  private static List<Genre> mapToGenres(List<String> genres) {

    return genres.stream()
        .map(
            g -> {
              var genre = new Genre();
              genre.setGenre(g);
              return genre;
            })
        .toList();
  }

  public static SoundResponse mapSoundToSoundResponse(List<Sound> sounds) {

    var data = sounds.stream().map(ObjectMappers::mapSoundToData).toList();
    var soundResponse = new SoundResponse();

    soundResponse.setData(data);

    return soundResponse;
  }

  private static SoundResponseData mapSoundToData(Sound sound) {

    var credits =
        sound.getCredits().stream()
            .map(
                cred -> {
                  var cre = new SoundResponseCredits();
                  cre.setName(cred.getName());
                  cre.setRole(cred.getRole());
                  return cre;
                })
            .collect(Collectors.toList());

    var genres = sound.getGenres().stream().map(Genre::getGenre).collect(Collectors.toList());

    SoundResponseData soundResponseData = new SoundResponseData();

    soundResponseData.setId(sound.getId());
    soundResponseData.setTitle(sound.getTitle());
    soundResponseData.setBpm(sound.getBpm());
    soundResponseData.setDuration_in_seconds(sound.getDurationInSeconds());
    soundResponseData.setGenres(genres);
    soundResponseData.setCredits(credits);

    return soundResponseData;
  }

  public static List<Playlist> mapCreatePlaylistRequestToPlaylist(
      CreatePlaylistRequest createPlaylistRequest) {

    var data = createPlaylistRequest.getData();

    return data.stream()
        .map(
            d -> {
              var playlist = new Playlist();

              playlist.setTitle(d.getTitle());
              playlist.setSoundIds(mapToSoundIds(d.getSounds()));
              return playlist;
            })
        .toList();
  }

  private static List<PlaylistSound> mapToSoundIds(List<String> sounds) {

    return sounds.stream()
        .map(
            c -> {
              var playlistSounds = new PlaylistSound();
              playlistSounds.setSoundId(c);
              return playlistSounds;
            })
        .toList();
  }

  public static PlaylistResponse mapPlaylistToPlaylistResponse(List<Playlist> playlist) {

    var playlistResponseData =
        playlist.stream().map(ObjectMappers::mapPlaylistToPlaylistResponseData).toList();
    var playlistResponse = new PlaylistResponse();

    playlistResponse.setData(playlistResponseData);

    return playlistResponse;
  }

  private static PlaylistResponseData mapPlaylistToPlaylistResponseData(Playlist playlist) {

    var soundIds = playlist.getSoundIds().stream().map(PlaylistSound::getSoundId).toList();

    var playlistResponseData = new PlaylistResponseData();
    playlistResponseData.setId(playlist.getId());
    playlistResponseData.setTitle((playlist.getTitle()));
    playlistResponseData.setSoundIds(soundIds);

    return playlistResponseData;
  }
}
