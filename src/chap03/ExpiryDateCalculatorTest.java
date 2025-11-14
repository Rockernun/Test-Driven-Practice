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
        LocalDate billingDate = LocalDate.of(2025, 11, 14);
        int payment = 10_000;

        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate expiryDate = calculator.calculateExpiryDate(billingDate, payment);

        assertEquals(LocalDate.of(2025, 12, 14), expiryDate);

        // 테스트 케이스 추가
        LocalDate billingDate2 = LocalDate.of(2025, 1, 14);
        int payment2 = 10_000;

        ExpiryDateCalculator calculator2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = calculator2.calculateExpiryDate(billingDate2, payment2);

        assertEquals(LocalDate.of(2025, 2, 14), expiryDate2);
    }
}
