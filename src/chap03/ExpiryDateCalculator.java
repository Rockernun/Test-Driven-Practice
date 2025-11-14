package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        int addedMonths = payData.getPayAmount() / 10_000;

        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = adjustExpiryDateToFirstBillingOrEndOfMonth(payData, addedMonths);
            if (candidateExp != null) {
                return candidateExp;
            }
        }

        return payData.getBillingDate().plusMonths(addedMonths);
    }

    private static LocalDate adjustExpiryDateToFirstBillingOrEndOfMonth(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
            if (YearMonth.from(candidateExp).lengthOfMonth() < payData.getFirstBillingDate().getDayOfMonth()) {
                return candidateExp.withDayOfMonth(YearMonth.from(candidateExp).lengthOfMonth());
            }

            return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
        }
        return null;
    }
}
