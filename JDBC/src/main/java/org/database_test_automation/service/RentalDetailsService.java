package org.database_test_automation.service;

import org.database_test_automation.mapper.RentalDetailsMapper;
import org.database_test_automation.model.RentalDetails;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class RentalDetailsService {

	public List<RentalDetails> getTableByGivenQuery(String query) {
		return DBUtils.executeQueryByGeneric(query, new RentalDetailsMapper());
	}

	public List<RentalDetails> getAllTableFromRental() {
		String query = "SELECT * FROM rental";
		return DBUtils.executeQueryByGeneric(query, new RentalDetailsMapper());
	}

	public RentalDetails getAllDataColumnByRentalId(int rentalId) {
		String query = "SELECT * FROM rental WHERE rental_id =" + rentalId;
		return DBUtils.executeQueryByGeneric(query, new RentalDetailsMapper()).get(0);
	}

}
