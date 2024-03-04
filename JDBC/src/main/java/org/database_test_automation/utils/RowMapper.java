package org.database_test_automation.utils;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws Exception;
}
