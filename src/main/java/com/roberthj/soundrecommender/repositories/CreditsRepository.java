package com.roberthj.soundrecommender.repositories;

import com.roberthj.soundrecommender.models.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditsRepository extends JpaRepository<Credit, String> {}
