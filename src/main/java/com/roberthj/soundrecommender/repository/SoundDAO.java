package com.roberthj.soundrecommender.repository;

import com.roberthj.soundrecommender.models.entities.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoundDAO extends JpaRepository<Sound, String> {

//    @Query("SELECT DISTINCT person FROM Person person " +
//            "JOIN FETCH person.addresses addresses")
//    List<Sound> retrieveAll();
}
