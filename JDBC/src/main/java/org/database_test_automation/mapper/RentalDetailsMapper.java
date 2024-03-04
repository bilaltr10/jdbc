package org.database_test_automation.mapper;

import org.database_test_automation.model.RentalDetails;
import org.database_test_automation.utils.RowMapper;

import java.sql.ResultSet;

public class RentalDetailsMapper implements RowMapper<RentalDetails> {

    @Override
    public RentalDetails mapRow(ResultSet rs) throws Exception {
        return new RentalDetails(rs.getInt("rental_id"),
              rs.getTimestamp("rental_date"),
                rs.getInt("inventory_id"),
                rs.getInt("customer_id"),
                rs.getTimestamp("return_date"),
                rs.getInt("staff_id"),
                rs.getTimestamp("last_update")
        );
    }
}
