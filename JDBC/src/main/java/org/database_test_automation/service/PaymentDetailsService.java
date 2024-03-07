package org.database_test_automation.service;

import org.database_test_automation.mapper.PaymentDetailsMapper;
import org.database_test_automation.model.PaymentDetails;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class PaymentDetailsService {

	public List<PaymentDetails> getAllPayment() {
		String query = "Select * from payment";
		return DBUtils.executeQueryByGeneric(query, new PaymentDetailsMapper());
	}

	public List<PaymentDetails> getTableByGivenQuery(String query) {
		return DBUtils.executeQueryByGeneric(query, new PaymentDetailsMapper());
	}

	public List<PaymentDetails> getPaymentDetailsTableByCustomerID(int customerId) {
		String query = "SELECT * from payment where customer_id = " + customerId;
		return DBUtils.executeQueryByGeneric(query, new PaymentDetailsMapper());
	}

	public List<PaymentDetails> getPaymentTableByAmount(String direction, String amount) {
		String query = "Select * from payment where amount " + direction + " " + amount;
		return DBUtils.executeQueryByGeneric(query, new PaymentDetailsMapper());
	}

}
