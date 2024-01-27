package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repository.CreditsDAO;
import com.roberthj.soundrecommender.repository.GenresDAO;
import com.roberthj.soundrecommender.repository.SoundDAO;
import org.springframework.stereotype.Service;

@Service
public class SoundRecommenderService {

    private final SoundDAO soundDAO;
    private final CreditsDAO creditsDAO;
    private final GenresDAO genresDAO;

    public SoundRecommenderService(SoundDAO soundDAO, CreditsDAO creditsDAO, GenresDAO genresDAO) {
        this.soundDAO = soundDAO;
        this.creditsDAO = creditsDAO;
        this.genresDAO = genresDAO;
    }

    public Sound createSound(Sound sound){

            var credits = sound.getCredits();
            var genres = sound.getGenres();

           var updated = soundDAO.save(sound);
            credits.forEach(credit -> {
                credit.setSoundId(updated.getId());
                creditsDAO.save(credit);
                        }
            );

            genres.forEach(genre -> {
                genre.setSoundId(updated.getId());
                genresDAO.save(genre);
            });








           var all = soundDAO.findAll();

    System.out.println();

    // Save to db

    // soundDAO.save();

    // Fetch and return item

    return sound;
    }
}
