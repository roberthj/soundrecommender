package com.roberthj.soundrecommender.repository;

import com.roberthj.soundrecommender.models.entities.PlaylistSound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistsSoundsDAO extends JpaRepository<PlaylistSound, String> {}
