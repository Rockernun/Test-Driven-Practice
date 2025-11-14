package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData paydata) {
        return paydata.getBillingDate().plusMonths(1);
    }
}
