package org.database_test_automation.service;

import org.database_test_automation.mapper.StaffDetailsMapper;
import org.database_test_automation.model.StaffDetails;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class StaffDetailsService {

	public List<StaffDetails> getTableByGivenQuery(String query) {
		return DBUtils.executeQueryByGeneric(query, new StaffDetailsMapper());
	}

}
