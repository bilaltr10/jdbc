package org.database_test_automation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetails {
    private int rentalId;
    private Timestamp rentalDate;
    private int inventoryId;
    private int customerId;
    private Timestamp returnDate;
    private int staffId;
    private Timestamp lastUpdate;
}
