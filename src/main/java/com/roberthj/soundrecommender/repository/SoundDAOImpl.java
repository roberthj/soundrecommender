//package com.roberthj.soundrecommender.repository;
//
//import com.roberthj.soundrecommender.models.entities.Credit;
//import com.roberthj.soundrecommender.models.entities.Genre;
//import com.roberthj.soundrecommender.models.entities.Sound;
//import jakarta.transaction.Transactional;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class SoundDAOImpl implements SoundDAO {
//
//  public static final String SAVE_NEW_SOUND =
//      "INSERT INTO SOUNDS(id, title, bpm, duration_in_seconds) VALUES(?,?,?,?)";
//  public static final String SAVE_NEW_SOUND_GENRE =
//      "INSERT INTO GENRES(sound_id, genre) VALUES(?,?)";
//
//    public static final String SAVE_NEW_SOUND_CREDITS =
//            "INSERT INTO CREDITS(sound_id, name, role) VALUES(?,?,?)";
//
//  public static final String FIND_ALL_SOUNDS =
//      "SELECT a.id, a.title, a.bpm, a.duration_in_seconds FROM sounds";
//  private final JdbcTemplate jdbcTemplate;
//
//  public SoundDAOImpl(JdbcTemplate jdbcTemplate) {
//    this.jdbcTemplate = jdbcTemplate;
//  }
//
//  @Override
//  @Transactional
//  public int saveNewSound(Sound sound) {
//
//    var items = jdbcTemplate.update(
//        SAVE_NEW_SOUND,
//        sound.getId(),
//        sound.getTitle(),
//        sound.getBpm(),
//        sound.getDurationInSeconds());
//
//    saveGenres(sound.getGenres());
//    saveCredits(sound.getCredits());
//
//    return items;
//
//  }
//
//    @Override
//    public List<Sound> findAll() {
//
//            return null;
//        }
//
//
//    private void saveGenres(List<Genre> genres) {
//
//    jdbcTemplate.batchUpdate(
//        SAVE_NEW_SOUND_GENRE,
//        new BatchPreparedStatementSetter() {
//
//          @Override
//          public void setValues(PreparedStatement ps, int i) throws SQLException {
//            ps.setString(1, genres.get(i).getSoundId());
//            ps.setString(2, genres.get(i).getGenre());
//          }
//
//          public int getBatchSize() {
//            return genres.size();
//          }
//        });
//  }
//    private void saveCredits(List<Credit> credits) {
//
//        jdbcTemplate.batchUpdate(
//                SAVE_NEW_SOUND_CREDITS,
//                new BatchPreparedStatementSetter() {
//
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setString(1, credits.get(i).getSoundId());
//                        ps.setString(2, credits.get(i).getName());
//                        ps.setString(3, credits.get(i).getRole());
//                    }
//
//                    public int getBatchSize() {
//                        return credits.size();
//                    }
//                });
//    }
//}
