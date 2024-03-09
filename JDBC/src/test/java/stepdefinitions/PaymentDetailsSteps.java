package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.database_test_automation.model.PaymentDetails;
import org.database_test_automation.service.PaymentDetailsService;
import java.util.List;

public class PaymentDetailsSteps {

	private static final Logger LOGGER = LogManager.getLogger(PaymentDetailsSteps.class);

	List<PaymentDetails> paymentDetailsList;

	PaymentDetailsService paymentDetailsService;

	@Given("the payment service is up and running")
	public void the_payment_service_is_up_and_running() {
		paymentDetailsService = new PaymentDetailsService();
		LOGGER.debug("PaymentDetailsService set up");

	}

	@When("I request a list of all payment")
	public void ı_request_a_list_of_all_rentals() {
		paymentDetailsList = paymentDetailsService.getAllPayment();
	}

	@Then("I should receive a list containing at least {string} columns")
	public void ıShouldReceiveAListContainingAtLeastColumns(String columnCount) {
		Assertions.assertThat(paymentDetailsList).as("List should return a lot of colums").isNotEmpty();
		LOGGER.info("Payment list size should be " + paymentDetailsList.size());
		LOGGER.debug("Payment list size should not be zero");
		Assertions.assertThat(paymentDetailsList.size()).isGreaterThan(Integer.parseInt(columnCount));
		LOGGER.info("Payment list size should be greater than" + columnCount);
	}

	@When("I request a list rentals by given customerId {string}")
	public void ı_request_a_list_rentals_by_given_customer_ıd(String customerId) {
		paymentDetailsList = paymentDetailsService.getPaymentDetailsTableByCustomerID(Integer.parseInt(customerId));
		LOGGER.info("I request a list rentals by given customerId" + customerId);
	}

	@Then("I should receive a list containing only given customerId {string}")
	public void ı_should_receive_a_list_containing_only_given_customer_ıd(String customerId) {
		if (!paymentDetailsList.isEmpty()) {
			LOGGER.info("Customer whose id is " + customerId + " has make shopping " + paymentDetailsList.size()
					+ " times ");
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getCustomerId()).isEqualTo(Integer.parseInt(customerId));
			}
		}
		else {
			LOGGER.info("There is not an customer by id of " + customerId);
		}
	}

	@When("I request a list rentals by given amount {string} and situation {string}")
	public void ı_request_a_list_rentals_by_given_amount_and_situation(String amount, String direction) {
		paymentDetailsList = paymentDetailsService.getPaymentTableByAmount(direction, amount);
	}

	@Then("I should receive a list contains whose amount {string} and direction {string}")
	public void ıShouldReceiveAListContainsWhoseAmountAndDirection(String amount, String direction) {
		if (direction.equals("<"))
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getAmount()).isLessThan(Double.parseDouble(amount));
			}
		else if (direction.equals(">")) {
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getAmount()).isGreaterThan(Double.parseDouble(amount));
			}
		}
		if (direction.equals("<="))
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getAmount()).isLessThanOrEqualTo(Double.parseDouble(amount));
			}
		else if (direction.equals(">=")) {
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getAmount()).isGreaterThanOrEqualTo(Double.parseDouble(amount));
			}
		}
		else if (direction.equals("=")) {
			for (PaymentDetails paymentDetails : paymentDetailsList) {
				Assertions.assertThat(paymentDetails.getAmount()).isEqualTo(Double.parseDouble(amount));
			}
		}
	}

}
