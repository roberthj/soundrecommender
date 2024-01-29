package com.roberthj.soundrecommender.utils;

import com.roberthj.soundrecommender.models.entities.*;
import com.roberthj.soundrecommender.models.playlistapirequests.CreatePlaylistRequest;
import com.roberthj.soundrecommender.models.playlistapiresponse.PlaylistResponse;
import com.roberthj.soundrecommender.models.playlistapiresponse.PlaylistResponseData;
import com.roberthj.soundrecommender.models.soundapirequests.CreateSoundRequest;
import com.roberthj.soundrecommender.models.soundapirequests.Credits;
import com.roberthj.soundrecommender.models.soundapiresponses.SoundResponse;
import com.roberthj.soundrecommender.models.soundapiresponses.SoundResponseData;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMappers {
  public static Sound mapCreateSoundRequestToSound(CreateSoundRequest createSoundRequest) {
    var data = createSoundRequest.getData();
    var cred = data.get(0).getCredits();
    var gen = data.get(0).getGenres();

    // TODO: fix these get(0)
    // Try ModelMapper

    var genres =
        gen.stream()
            .map(
                g -> {
                  var genre = new Genre();
                  genre.setGenre(g);
                  return genre;
                })
            .collect(Collectors.toList());

    var credits =
        cred.stream()
            .map(
                c -> {
                  var credit = new Credit();
                  credit.setRole(c.getRole());
                  credit.setName(c.getName());
                  return credit;
                })
            .collect(Collectors.toList());

    var sound = new Sound();

    sound.setTitle(data.get(0).getTitle());
    sound.setBpm(data.get(0).getBpm());
    sound.setDurationInSeconds(data.get(0).getDuration_in_seconds());
    sound.setGenres(genres);
    sound.setCredits(credits);

    return sound;
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
                  var cre = new Credits();
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

  public static Playlist mapCreatePlaylistRequestToPlaylist(CreatePlaylistRequest createPlaylistRequest){

      var data = createPlaylistRequest.getData().get(0);
      var soundIds =
              data.getSounds()
                      .stream()
                      .toList();

      var soundsIds =
              data.getSounds().stream()
                      .map(
                              c -> {
                                  var playlistSounds = new PlaylistSound();
                                  playlistSounds.setSoundId(c);
                                  return playlistSounds;
                              })
                      .toList();



      var playlist = new Playlist();

      playlist.setTitle(data.getTitle());
      playlist.setSoundIds(soundsIds);

      return playlist;

  }
    public static PlaylistResponse mapPlaylistToPlaylistResponse(List<Playlist> playlist){

        var playlistResponseData = playlist.stream().map(ObjectMappers::mapPlaylistToPlaylistResponseData).toList();
        var playlistResponse = new PlaylistResponse();

        playlistResponse.setData(playlistResponseData);

        return playlistResponse;

    }


    private static PlaylistResponseData mapPlaylistToPlaylistResponseData(Playlist playlist){

      var soundIds =
              playlist
                      .getSoundIds()
                      .stream()
                      .map(PlaylistSound::getSoundId)
                      .toList();

        var playlistResponseData = new PlaylistResponseData();
            playlistResponseData.setId(playlist.getId());
            playlistResponseData.setTitle((playlist.getTitle()));
            playlistResponseData.setSoundIds(soundIds);



        return playlistResponseData;

    }
}
