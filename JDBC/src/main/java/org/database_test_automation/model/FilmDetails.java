package org.database_test_automation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDetails {

	private int filmId;

	private String title;

	private String description;

	private int releaseYear;

	private int languageId;

	private int rentalDuration;

	private double rentalRate;

	private int length;

	private double replacementCost;

	private String rating;

	private Timestamp lastUpdate;

	private Array specialFeature;

	private Object fulltext;

}
