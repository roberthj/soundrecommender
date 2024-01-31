package com.roberthj.soundrecommender.repositories;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test-containers-flyway")
public class PlaylistRepositoryIT {

    @Autowired PlaylistsRepository playlistsRepository;
    @Disabled("Test to implemented")
    @Test
    @Transactional
    void shouldSavePlaylistAndItsChildUsingTheSameSoundId() {

    }

}
