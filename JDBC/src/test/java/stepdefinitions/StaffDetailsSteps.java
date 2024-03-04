package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.database_test_automation.model.StaffDetails;
import org.database_test_automation.service.StaffDetailsService;

import java.util.List;

public class StaffDetailsSteps {
    private static final Logger LOGGER = LogManager.getLogger(StaffDetailsSteps.class);

    List<StaffDetails> staffDetailsList;
}
