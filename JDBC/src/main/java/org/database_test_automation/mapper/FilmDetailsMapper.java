package org.database_test_automation.mapper;

import org.database_test_automation.model.FilmDetails;

import org.database_test_automation.utils.RowMapper;

import java.sql.ResultSet;

public class FilmDetailsMapper implements RowMapper<FilmDetails> {


    @Override
    public FilmDetails mapRow(ResultSet rs) throws Exception {
        return new FilmDetails(rs.getInt("film_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getInt("language_id"),
                rs.getInt("rental_duration"),
                rs.getDouble("rental_rate"),
                rs.getInt("length"),
                rs.getDouble("replacement_cost"),
                rs.getString("rating"),
                rs.getTimestamp("last_update"),
                rs.getArray("special_features"),
                rs.getString("fulltext")
        );
    }
}
