package com.roberthj.soundrecommender.utils;

import com.roberthj.soundrecommender.models.entities.Credit;
import com.roberthj.soundrecommender.models.entities.Genre;
import com.roberthj.soundrecommender.models.entities.Sound;
import com.roberthj.soundrecommender.models.sounddtos.CreateSoundRequest;
import com.roberthj.soundrecommender.models.sounddtos.CreateSoundRequestData;
import com.roberthj.soundrecommender.models.sounddtos.CreateSoundRequestCredits;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.roberthj.soundrecommender.utils.ObjectMappers.mapCreateSoundRequestToSounds;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ObjectMappersTest {

    public static final String ARTIST_NAME = "Artist name";
    public static final String GENRE = "genre";
    public static final String ROLE = "role";
    public static final String TITLE = "Title";
    public static final int BPM = 120;
    public static final int DURATION_IN_SECONDS = 160;

    @Test
    public void verifyThatCreateSoundRequestIsMappedToListOfSounds(){

        var createSoundRequest = mockedCreateSoundRequest();

        var expectedResult = List.of(mockedSound());

        var result = mapCreateSoundRequestToSounds(createSoundRequest);

        assertEquals(expectedResult, result);
    }


    @Disabled("Test to implemented similar to the test above")
    @Test
    public void verifyThatSoundIsMappedToSoundResponse(){
    }

    @Disabled("Test to implemented similar to the test above")
    @Test
    public void verifyThatCreatePlaylistRequestIsMappedToPlaylist(){
    }
    @Disabled("Test to implemented similar to the test above")
    @Test
    public void verifyThatPlaylistIsMappedToPlaylistResponse(){
    }


    private Sound mockedSound() {

        var genre = new Genre();
        genre.setGenre(GENRE);

        var credits = new Credit();
        credits.setName(ARTIST_NAME);
        credits.setRole(ROLE);

        var sound = new Sound();
        sound.setTitle(TITLE);
        sound.setBpm(BPM);
        sound.setDurationInSeconds(DURATION_IN_SECONDS);
        sound.setGenres(List.of(genre));
        sound.setCredits(List.of(credits));

        return sound;
    }

    private CreateSoundRequest mockedCreateSoundRequest() {

        var credits = new CreateSoundRequestCredits();
        credits.setName(ARTIST_NAME);
        credits.setRole(ROLE);

        var createSoundRequestData = new CreateSoundRequestData();
        createSoundRequestData.setTitle(TITLE);
        createSoundRequestData.setBpm(BPM);
        createSoundRequestData.setDuration_in_seconds(DURATION_IN_SECONDS);
        createSoundRequestData.setGenres(List.of(GENRE));
        createSoundRequestData.setCredits(List.of(credits));

        var createSoundRequest = new CreateSoundRequest();
        createSoundRequest.setData(List.of(createSoundRequestData));

        return createSoundRequest;

    }

}
