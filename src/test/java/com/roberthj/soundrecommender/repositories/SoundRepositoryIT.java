package com.roberthj.soundrecommender.repositories;


import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test-containers-flyway")
public class SoundRepositoryIT {
    public static final String ARTIST_NAME = "Artist name";
    public static final String GENRE = "genre";
    public static final String ROLE = "role";
    public static final String TITLE = "Title";
    public static final int BPM = 120;
    public static final int DURATION_IN_SECONDS = 160;
    @Autowired SoundRepository soundRepository;

    @Test
    @Transactional
    void shouldSaveToRepositoryAndFetchAllShouldGetAll() {

        var sound = mockedSound(null);

        var credits = sound.getCredits();
        var genres = sound.getGenres();
        genres.forEach(genre -> genre.setSound(sound));
        credits.forEach(credit -> credit.setSound(sound));

        soundRepository.save(sound);

        var sound2 = mockedSound(null);

        var credits2 = sound2.getCredits();
        var genres2 = sound2.getGenres();
        genres2.forEach(genre2 -> genre2.setSound(sound2));
        credits2.forEach(credit2 -> credit2.setSound(sound2));


        soundRepository.save(sound2);

        var fetchedSound = soundRepository.findAll();

        assertEquals(2, fetchedSound.size());


    }

    @Test
    @Transactional
    void shouldSaveSoundAndItsChildrenUsingTheSameSoundId() {

        var sound = mockedSound(null);

        var credits = sound.getCredits();
        var genres = sound.getGenres();
        genres.forEach(genre -> genre.setSound(sound));
        credits.forEach(credit -> credit.setSound(sound));


        var saved =soundRepository.save(sound);

        var expectedResult = mockedSound(saved.getId());

        var fetchedSound = soundRepository.findById(saved.getId()).get();

        assertEquals(expectedResult.getId(), fetchedSound.getId());
        assertEquals(expectedResult.getGenres().get(0).getSound().getId(),
                fetchedSound.getGenres().get(0).getSound().getId());
        assertEquals(expectedResult.getCredits().get(0).getSound().getId(),
                fetchedSound.getCredits().get(0).getSound().getId());

  }


    private Sound mockedSound(String soundId) {

        var genre = new Genre();
        genre.setGenre(GENRE);
        if(soundId != null ){
            var sound = new Sound();
            sound.setId(soundId);
            genre.setSound(sound);
        }

        var credits = new Credit();
        credits.setName(ARTIST_NAME);
        credits.setRole(ROLE);
        if(soundId != null ){
            var sound = new Sound();
            sound.setId(soundId);
            credits.setSound(sound);
        }

        var sound = new Sound();
        sound.setTitle(TITLE);
        sound.setBpm(BPM);
        sound.setDurationInSeconds(DURATION_IN_SECONDS);
        sound.setGenres(List.of(genre));
        sound.setCredits(List.of(credits));

        if(soundId != null ){
            sound.setId(soundId);
        }

        return sound;
    }
}


