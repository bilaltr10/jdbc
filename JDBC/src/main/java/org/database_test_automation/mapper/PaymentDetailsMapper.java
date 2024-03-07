package org.database_test_automation.mapper;

import org.database_test_automation.model.PaymentDetails;
import org.database_test_automation.utils.RowMapper;

import java.sql.ResultSet;

public class PaymentDetailsMapper implements RowMapper<PaymentDetails> {

	@Override
	public PaymentDetails mapRow(ResultSet rs) throws Exception {
		return new PaymentDetails(rs.getInt("payment_id"), rs.getInt("customer_id"), rs.getInt("staff_id"),
				rs.getInt("rental_id"), rs.getDouble("amount"), rs.getTimestamp("payment_date"));
	}

}
