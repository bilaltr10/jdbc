package org.database_test_automation.mapper;

import org.database_test_automation.model.FilmDetailsTask;
import org.database_test_automation.utils.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class FilmDetailsTaskMapper implements RowMapper<FilmDetailsTask> {
    @Override
    public FilmDetailsTask mapRow(ResultSet rs) throws Exception {
        return new FilmDetailsTask(rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getString("category"),
                rs.getString("actor_list"));
    }
}
