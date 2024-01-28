//package com.roberthj.soundrecommender.repository;
//
//import com.roberthj.soundrecommender.models.entities.Credit;
//import com.roberthj.soundrecommender.models.entities.Genre;
//import com.roberthj.soundrecommender.models.entities.Sound;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SoundRowMapper implements RowMapper<Sound> {
//
//  @Override
//  public Sound mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//    var genreBuilder = Genre.builder();
//
//    genreBuilder.soundId(rs.getString("id")).genre(rs.getString("genre"));
//
//    var creditsBuilder = Credit.builder();
//
//    creditsBuilder
//        .soundId(rs.getString("id"))
//        .name(rs.getString("name"))
//        .role(rs.getString("role"));
//
//
//      var soundBuilder = Sound.builder();
//
//      soundBuilder
//          .id(rs.getString("id"))
//          .title(rs.getString("title"))
//          .bpm(rs.getInt("bpm"))
//          .durationInSeconds(rs.getInt("duration_in_seconds"))
//          .genres(List.of(genreBuilder.build()))
//          .credits(List.of(creditsBuilder.build()));
//
//
//      return soundBuilder.build();
//
//  }
//}
