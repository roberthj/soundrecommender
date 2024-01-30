package com.roberthj.soundrecommender.repositories;

import com.roberthj.soundrecommender.models.entities.PlaylistSound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistsSoundsRepository extends JpaRepository<PlaylistSound, String> {}
