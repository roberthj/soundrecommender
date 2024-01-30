package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Sound;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecommendationService {
    List<Sound> getRecommendations(String playlistId);

}
