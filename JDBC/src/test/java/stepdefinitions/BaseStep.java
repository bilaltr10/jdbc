package stepdefinitions;

import org.database_test_automation.utils.ConfigManager;

public abstract class BaseStep {

	private String dbURL;

	private String dbUserName;

	private String dbPassword;

	public BaseStep() {
		dbURL = ConfigManager.getProperty("db_URL");
		dbUserName = ConfigManager.getProperty("db_username");
		dbPassword = ConfigManager.getProperty("db_password");
	}

}
