package com.roberthj.soundrecommender.repositories;

import com.roberthj.soundrecommender.models.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistsRepository extends JpaRepository<Playlist, String> {

}
