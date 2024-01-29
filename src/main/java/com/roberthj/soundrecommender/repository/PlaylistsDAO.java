package com.roberthj.soundrecommender.repository;

import com.roberthj.soundrecommender.models.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistsDAO extends JpaRepository<Playlist, String> {

}
