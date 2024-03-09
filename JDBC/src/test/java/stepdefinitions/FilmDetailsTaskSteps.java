package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.database_test_automation.model.FilmDetailsTask;
import org.database_test_automation.service.FilmDetailsTaskService;

import java.util.List;

public class FilmDetailsTaskSteps {
    List<FilmDetailsTask> filmDetailsTasksList ;
    FilmDetailsTaskService filmDetailsTaskService;

    @Given("the filmdetails service is up and running")
    public void the_filmdetails_service_is_up_and_running() {
        filmDetailsTaskService = new FilmDetailsTaskService();

    }
    @When("I request a list of all filmDetails")
    public void ı_request_a_list_of_all_film_details() {
       filmDetailsTasksList = filmDetailsTaskService.getAllData();
    }


    @Then("I should receive a list of filmDetails covers given data")
    public void ıShouldReceiveAListOfFilmDetailsCoversGivenData(DataTable dataTable) {

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 1; i < dataTable.height(); i++) {
            System.out.println(dataTable.cell(i,4));
            softAssertions.assertThat(filmDetailsTasksList.get(i).getActorList()).isEqualTo(dataTable.cell(i,4));
            softAssertions.assertThat(filmDetailsTasksList.get(i).getTitle()).isEqualTo(dataTable.cell(i,0));
            softAssertions.assertThat(filmDetailsTasksList.get(i).getDescription()).isEqualTo(dataTable.cell(i,1));
            softAssertions.assertThat(filmDetailsTasksList.get(i).getReleaseYear()).isEqualTo(dataTable.cell(i,2));
            softAssertions.assertThat(filmDetailsTasksList.get(i).getCategory()).isEqualTo(dataTable.cell(i,3));

        }
    }
}
