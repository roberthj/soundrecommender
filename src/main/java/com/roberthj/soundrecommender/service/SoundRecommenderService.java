package com.roberthj.soundrecommender.service;

import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.repository.SoundDAO;
import org.springframework.stereotype.Service;

@Service
public class SoundRecommenderService {

    private final SoundDAO soundDAO;

    public SoundRecommenderService( SoundDAO soundDAO) {
        this.soundDAO = soundDAO;
    }

    public Sound createSound(Sound sound){



        //Save to db
        var tmp = soundDAO.save(sound);






        //soundDAO.save();


        //Fetch and return item

        return sound;

    }
}
