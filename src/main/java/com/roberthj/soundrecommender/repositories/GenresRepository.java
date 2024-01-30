package com.roberthj.soundrecommender.repositories;

import com.roberthj.soundrecommender.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genre, String> {}
