package org.database_test_automation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StaffDetails {

	private int staffId;

	private String firstName;

	private String lastName;

	private int addressId;

	private String email;

	private int storeId;

	private boolean active;

	private String username;

	private String password;

	private Timestamp lastUpdate;

	private Object picture;

}
