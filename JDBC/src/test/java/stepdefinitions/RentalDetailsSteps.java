package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.database_test_automation.model.RentalDetails;
import org.database_test_automation.service.RentalDetailsService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class RentalDetailsSteps {

	private static final Logger LOGGER = LogManager.getLogger(RentalDetailsSteps.class);

	List<RentalDetails> rentalDetailsList;

	private RentalDetailsService rentalDetailsService;

	private RentalDetails rentalDetails;

	@Given("the rental service is up and running")
	public void the_service_is_up_and_running() {
		rentalDetailsService = new RentalDetailsService();
	}

	@When("I request a list of all rentals")
	public void ı_request_a_list_of_all_rentals() {
		rentalDetailsList = rentalDetailsService.getAllTableFromRental();
	}

	@Then("I should receive a list containing all rentals in the database")
	public void ı_should_receive_a_list_containing_all_rentals_in_the_database() {
		SoftAssertions softAssertions = new SoftAssertions();
		for (RentalDetails rentalDetails : rentalDetailsList) {
			softAssertions.assertThat(rentalDetails.getRentalId()).isInstanceOf(Integer.class);
			System.out.println(rentalDetails.getRentalId());
			softAssertions.assertThat(rentalDetails.getRentalId()).isGreaterThan(0);
			softAssertions.assertThat(rentalDetails.getRentalDate()).isInstanceOf(Timestamp.class);
			softAssertions.assertThat(rentalDetails.getCustomerId()).isInstanceOf(Integer.class);
			softAssertions.assertThat(rentalDetails.getCustomerId()).isGreaterThan(0);
			softAssertions.assertThat(rentalDetails.getInventoryId()).isInstanceOf(Integer.class);
			softAssertions.assertThat(rentalDetails.getInventoryId()).isGreaterThan(0);
			softAssertions.assertThat(rentalDetails.getLastUpdate()).isInstanceOf(Timestamp.class);
			softAssertions.assertThat(rentalDetails.getStaffId()).isInstanceOf(Integer.class);
			softAssertions.assertThat(rentalDetails.getStaffId()).isGreaterThan(0);
		}
		softAssertions.assertAll();
	}

	@When("I request data column by rental id {string}")
	public void ı_request_data_column_by_rental_id(String rental_id) {
		rentalDetails = rentalDetailsService.getAllDataColumnByRentalId(Integer.parseInt(rental_id));
	}

	@Then("data should match with given data")
	public void data_should_match_with_given_data(DataTable dataTable) {
		Map<String, String> givenData = dataTable.asMap(String.class, String.class);
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(String.valueOf(rentalDetails.getRentalId())).isEqualTo(givenData.get("rentalId"));
		softAssertions.assertThat(String.valueOf(rentalDetails.getRentalDate()))
			.contains(givenData.get("rentalDate").replace("\"", ""));
		softAssertions.assertThat(String.valueOf(rentalDetails.getInventoryId()))
			.isEqualTo(givenData.get("inventoryId"));
		softAssertions.assertThat(String.valueOf(rentalDetails.getCustomerId())).isEqualTo(givenData.get("customerId"));
		softAssertions.assertThat(String.valueOf(rentalDetails.getReturnDate()))
			.contains(givenData.get("returnDate").replace("\"", ""));
		softAssertions.assertThat(String.valueOf(rentalDetails.getStaffId())).isEqualTo(givenData.get("staffId"));
		softAssertions.assertThat(String.valueOf(rentalDetails.getLastUpdate()))
			.contains(givenData.get("lastUpdate").replace("\"", ""));
		softAssertions.assertAll();
	}

}
