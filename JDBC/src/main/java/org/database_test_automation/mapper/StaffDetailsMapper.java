package org.database_test_automation.mapper;

import org.database_test_automation.model.StaffDetails;
import org.database_test_automation.utils.RowMapper;

import java.sql.ResultSet;

public class StaffDetailsMapper implements RowMapper<StaffDetails> {
    @Override
    public StaffDetails mapRow(ResultSet rs) throws Exception {
        return new StaffDetails(
                rs.getInt("staff_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("address_id"),
                rs.getString("email"),
                rs.getInt("store_id"),
                rs.getBoolean("active"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getTimestamp("last_update"),
                rs.getObject("picture")
        );
    }
}
