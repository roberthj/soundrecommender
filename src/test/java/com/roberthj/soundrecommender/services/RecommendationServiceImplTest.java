package com.roberthj.soundrecommender.services;

import com.roberthj.soundrecommender.repositories.SoundRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceImplTest {

    @Mock
    SoundRepository soundRepository;

    @InjectMocks RecommendationServiceImpl recommendationService;

    @Disabled("Test to implemented")
    @Test
    public void verifyThatGetRecommendationsReturnAListofSounds(){
    }

    @Disabled("Test to implemented")
    @Test
    public void verifyThatSoundsFromTheProvidedPlayListAreNotReturned(){
    }

    @Disabled("Test to implemented")
    @Test
    public void verifyThatAllReturnedSoundsAreFromArtistsInProvidedPlaylist(){

    }



}
