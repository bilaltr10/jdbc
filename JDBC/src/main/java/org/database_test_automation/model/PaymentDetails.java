package org.database_test_automation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {
    private int paymentId;
    private int customerId;
    private int staffId;
    private int rentalId;
    private double amount;
    private Timestamp paymentDate;
}
