package org.database_test_automation.service;

import org.database_test_automation.mapper.FilmDetailsTaskMapper;
import org.database_test_automation.model.FilmDetailsTask;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class FilmDetailsTaskService {

    public String queryForCreateJoinedFilmTable(){
        return "SELECT\n" +
                "    f.title,\n" +
                "    f.description,\n" +
                "    f.release_year,\n" +
                "    c.name AS category,\n" +
                "    STRING_AGG(a.first_name || ' ' || a.last_name, ', ') AS actor_list\n" +
                "FROM\n" +
                "    film f\n" +
                "JOIN\n" +
                "    film_category fc ON f.film_id = fc.film_id\n" +
                "JOIN\n" +
                "    category c ON fc.category_id = c.category_id\n" +
                "JOIN\n" +
                "    film_actor fa ON f.film_id = fa.film_id\n" +
                "JOIN\n" +
                "    actor a ON fa.actor_id = a.actor_id\n" +
                "GROUP BY\n" +
                "    f.title, f.description, f.release_year, c.name;";
    }

    public List<FilmDetailsTask> getAllData(){
        return DBUtils.executeQueryByGeneric(queryForCreateJoinedFilmTable(),new FilmDetailsTaskMapper());
    }
}
