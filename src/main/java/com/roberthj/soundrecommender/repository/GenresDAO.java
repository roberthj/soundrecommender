package com.roberthj.soundrecommender.repository;

import com.roberthj.soundrecommender.models.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresDAO extends CrudRepository<Genre, String> {}
