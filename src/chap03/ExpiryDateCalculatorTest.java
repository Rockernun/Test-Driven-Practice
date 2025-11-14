package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 시나리오 설정: 구독 서비스
 * 서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한 달 뒤가 서비스 만료일이 된다
 * 2개월 이상 요금을 납부할 수 있다.
 * 10만 원을 납부하면 서비스를 1년동안 이용할 수 있다.
 */


public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_된다() {
        assertExpiryDate(LocalDate.of(2025, 12, 14), LocalDate.of(2025, 11, 14), 10_000);
        assertExpiryDate(LocalDate.of(2025, 2, 14), LocalDate.of(2025, 1, 14), 10_000);
    }

    private static void assertExpiryDate(LocalDate expectedExpiryDate, LocalDate billingDate, int payment) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate realExpiryDate = calculator.calculateExpiryDate(billingDate, payment);

        assertEquals(expectedExpiryDate, realExpiryDate);
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않다() {
        assertExpiryDate(LocalDate.of(2025, 2, 28), LocalDate.of(2025, 1, 31), 10_000);
        assertExpiryDate(LocalDate.of(2025, 6, 30), LocalDate.of(2025, 5, 31), 10_000);
    }
}
