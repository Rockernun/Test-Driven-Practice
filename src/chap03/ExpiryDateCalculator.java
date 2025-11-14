package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(LocalDate date, int payment) {
        return date.plusMonths(1);
    }
}
