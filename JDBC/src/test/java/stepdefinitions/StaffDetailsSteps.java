package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.database_test_automation.model.StaffDetails;
import org.database_test_automation.service.StaffDetailsService;
import java.util.List;
import java.util.Map;

public class StaffDetailsSteps {

    private static final Logger LOGGER = LogManager.getLogger(StaffDetailsSteps.class);

    List<StaffDetails> staffDetailsList;
    private StaffDetailsService staffDetailsService;

    @Given("the staff service is up and running")
    public void the_staff_service_is_up_and_running() {
        staffDetailsService = new StaffDetailsService();
    }

    @When("I request a list of all staff")
    public void ı_request_a_list_of_all_staff() {
        staffDetailsList = staffDetailsService.getAllTableFromStaff();
    }

    @Then("I should receive a list containing all staff in the database")
    public void ı_should_receive_a_list_containing_all_staff_in_the_database(DataTable dataTable) {
        Map<String,String> givenTable = dataTable.asMap(String.class,String.class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (StaffDetails staffDetails : staffDetailsList) {
            softAssertions.assertThat(String.valueOf(staffDetails.getStaffId())).isEqualTo(givenTable.get("staffId").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getFirstName())).isEqualTo(givenTable.get("firstName").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getLastName())).isEqualTo(givenTable.get("lastName").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getAddressId())).isEqualTo(givenTable.get("addressId").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getEmail())).isEqualTo(givenTable.get("email").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getStoreId())).isEqualTo(givenTable.get("storeId").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.isActive())).isEqualTo(givenTable.get("active").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getUsername())).isEqualTo(givenTable.get("userName").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getPassword())).isEqualTo(givenTable.get("password").replace("\"", ""));
            softAssertions.assertThat(String.valueOf(staffDetails.getLastName())).isEqualTo(givenTable.get("lastUpdate").replace("\"", ""));
        }

softAssertions.assertAll();

    }

}
