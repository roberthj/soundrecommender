package com.roberthj.soundrecommender.repositories;

import com.roberthj.soundrecommender.models.entities.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoundRepository extends JpaRepository<Sound, String> {


  @Query(
      value = "select s.* from sounds s\n"
          + "join playlists_sounds ps on s.id = ps.sound_id\n"
          + "where ps.playlist_id = :playlistId", nativeQuery = true)
  List<Sound> findSongsFromPlaylist(@Param("playlistId") String playlistId);

  @Query(
          value = "select s.* from sounds s " +
                  "join credits c on s.id = c.sound_id " +
                  "where c.name in (:artists)", nativeQuery = true)
  List<Sound> findSongsByArtist(@Param("artists") List<String> artists);
}



