package org.database_test_automation.service;

import org.database_test_automation.mapper.FilmDetailsMapper;
import org.database_test_automation.model.FilmDetails;
import org.database_test_automation.utils.DBUtils;
import java.util.List;

public class FilmDetailsService {

	public FilmDetailsService() {

	}

	public List<FilmDetails> getAllFromFilm() {
		String query = "SELECT * FROM film";
		return DBUtils.executeQueryByGeneric(query, new FilmDetailsMapper());
	}

	public List<FilmDetails> getFilmNamesLike(String aPartOfFilmName) {
		String query = "SELECT * FROM film WHERE title like '%" + aPartOfFilmName + "%'";
		return DBUtils.executeQueryByGeneric(query, new FilmDetailsMapper());
	}

	public FilmDetails getFilmByFilmId(int filmId) {
		String query = "Select * from film where film_id =" + filmId;
		return DBUtils.executeQueryByGeneric(query, new FilmDetailsMapper()).get(0);
	}

	public List<FilmDetails> getTableByGivenQuery(String query) {
		return DBUtils.executeQueryByGeneric(query, new FilmDetailsMapper());
	}

}
