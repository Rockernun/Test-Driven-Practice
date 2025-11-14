package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData paydata) {

        int addedMonths = paydata.getPayAmount() / 10_000;

        if (paydata.getFirstBillingDate() != null) {
            LocalDate candidateExp = paydata.getBillingDate().plusMonths(addedMonths);
            if (paydata.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(
                        paydata.getFirstBillingDate().getDayOfMonth()
                );
            }
        }

        return paydata.getBillingDate().plusMonths(addedMonths);
    }
}
