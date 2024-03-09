package org.database_test_automation.service;

import org.database_test_automation.mapper.RentalDetailsMapper;
import org.database_test_automation.mapper.StaffDetailsMapper;
import org.database_test_automation.model.RentalDetails;
import org.database_test_automation.model.StaffDetails;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class StaffDetailsService {

	public List<StaffDetails> getTableByGivenQuery(String query) {
		return DBUtils.executeQueryByGeneric(query, new StaffDetailsMapper());
	}
	public List<StaffDetails> getAllTableFromStaff() {
		String query = "SELECT * FROM staff";
		return DBUtils.executeQueryByGeneric(query, new StaffDetailsMapper());
	}

	public StaffDetails getAllDataColumnByStaffId(int rentalId) {
		String query = "SELECT * FROM staff WHERE staff_id =" + rentalId;
		return DBUtils.executeQueryByGeneric(query, new StaffDetailsMapper()).get(0);
	}

	public StaffDetails getAllDataColumnByFirstName(String firstName) {
		String query = "SELECT * FROM staff WHERE first_name = '" + firstName+"'";
		return DBUtils.executeQueryByGeneric(query, new StaffDetailsMapper()).get(0);
	}

}
