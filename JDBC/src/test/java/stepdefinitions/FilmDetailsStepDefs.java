package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.database_test_automation.model.FilmDetails;
import org.database_test_automation.service.FilmDetailsService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilmDetailsStepDefs {

	private static final Logger LOGGER = LogManager.getLogger(FilmDetailsStepDefs.class);

	private FilmDetailsService filmDetailsService;

	private List<FilmDetails> filmDetailsList;

	private FilmDetails filmDetails;

	@Given("the film service is up and running")
	public void the_film_service_is_up_and_running() {
		filmDetailsService = new FilmDetailsService();
	}

	@When("I request a list of all films")
	public void ı_request_a_list_of_all_films() {
		filmDetailsList = filmDetailsService.getAllFromFilm();
	}

	@Then("I should receive a list containing all films in the database")
	public void ı_should_receive_a_list_containing_all_films_in_the_database() {
		assertThat(filmDetailsList).as("Check if the film list is not null and not empty").isNotNull().isNotEmpty();
	}

	@When("I request a film list contains {string}")
	public void ı_request_a_film_list_contains(String filmName) {
		filmDetailsList = filmDetailsService.getFilmNamesLike(filmName);
	}

	@Then("All the films appeared should contain {string}")
	public void all_the_films_appeared_should_contain(String filmName) {
		SoftAssertions softAssertions = new SoftAssertions();
		if (filmDetailsList != null) {
			for (FilmDetails filmDetails : filmDetailsList) {
				softAssertions.assertThat(filmDetails.getTitle())
					.as("film should contains word of" + filmName)
					.contains(filmName);
			}
			softAssertions.assertAll();
		}
		else {
			LOGGER.info("There is not a film contains name of" + filmName);
		}

	}

	@When("I request title and description of films by IDs {string}")
	public void ı_request_title_and_description_of_films_by_ı_ds(String filmId) {
		filmDetails = filmDetailsService.getFilmByFilmId(Integer.parseInt(filmId));
	}

	@Then("I should receive the title {string} and description {string} of the film with ID {string}")
	public void ıShouldReceiveTheTitleAndDescriptionOfTheFilmWithID(String filmId, String filmTitle,
			String filmDescription) {
		Assertions.assertThat(filmDetails.getFilmId()).isEqualTo(Integer.parseInt(filmId));
		Assertions.assertThat(filmDetails.getTitle()).isEqualTo(filmTitle.replace("\"", ""));
		Assertions.assertThat(filmDetails.getDescription()).isEqualTo(filmDescription.replace("\"", ""));
	}

}
