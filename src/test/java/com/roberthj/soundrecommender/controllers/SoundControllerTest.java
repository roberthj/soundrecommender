package com.roberthj.soundrecommender.controllers;

import com.roberthj.soundrecommender.Application;
import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.services.RecommendationService;
import com.roberthj.soundrecommender.services.SoundService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(SoundController.class)
class SoundControllerTest {
    public static final String ARTIST_NAME = "Artist name";
    public static final String GENRE = "genre";
    public static final String ROLE = "role";
    public static final String TITLE = "Title";
    public static final int BPM = 120;
    public static final int DURATION_IN_SECONDS = 160;

    public static final String SOUND_ID = "soundId";
    @Autowired
    MockMvc mvc;
    @MockBean
    SoundService soundService;

    @MockBean
    RecommendationService recommendationService;

    @Test
    public void getSoundsReturnCorrectJson()
            throws Exception {

        var sound = mockedSound();

        when(soundService.getSounds()).thenReturn(List.of(sound));

    mvc.perform(get("/sounds").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data").isNotEmpty())
            .andExpect(jsonPath("$.data[0].title").exists())
            .andExpect(jsonPath("$.data[0].title").isString())
            .andExpect(jsonPath("$.data[0].title").isNotEmpty());

    }

    @Disabled("Test to implemented")
    @Test
    public void createSoundsReturnCorrectJson(){

    }
    @Disabled("Test to implemented")
    @Test
    public void recommendSoundsReturnCorrectJson(){

    }

    @Disabled("Test to implemented")
    @Test
    public void verifyThatCreateSoundsReturnsBadRequestWhenSaveToDbThrowsDataIntegrityViolationException(){

    }




    private Sound mockedSound() {

        var genre = new Genre();
        genre.setGenre(GENRE);

        var credits = new Credit();
        credits.setName(ARTIST_NAME);
        credits.setRole(ROLE);

        var sound = new Sound();
        sound.setId(SOUND_ID);
        sound.setTitle(TITLE);
        sound.setBpm(BPM);
        sound.setDurationInSeconds(DURATION_IN_SECONDS);
        sound.setGenres(List.of(genre));
        sound.setCredits(List.of(credits));

        return sound;
    }


}
