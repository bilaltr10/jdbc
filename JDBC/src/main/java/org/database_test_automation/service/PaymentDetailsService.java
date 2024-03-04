package org.database_test_automation.service;

import org.database_test_automation.mapper.PaymentDetailsMapper;
import org.database_test_automation.model.PaymentDetails;
import org.database_test_automation.utils.DBUtils;

import java.util.List;

public class PaymentDetailsService {

    public List<PaymentDetails> getAllPayment(){
        String query = "Select * from payment";
        return DBUtils.executeQueryByGeneric(query,new PaymentDetailsMapper());
    }
}
