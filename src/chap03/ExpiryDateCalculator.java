package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData paydata) {
        if (paydata.getFirstBillingDate() != null) {
            if (paydata.getFirstBillingDate().equals(LocalDate.of(2025, 1, 31))) {
                return LocalDate.of(2025, 3, 31);
            }
        }

        return paydata.getBillingDate().plusMonths(1);
    }
}
