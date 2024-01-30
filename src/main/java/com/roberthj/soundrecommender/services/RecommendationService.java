package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.models.entities.Sound;

import java.util.List;

public interface RecommendationService {
    List<Sound> getRecommendations(String playlistId);

}
