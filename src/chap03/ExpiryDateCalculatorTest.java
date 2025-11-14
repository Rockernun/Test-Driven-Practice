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
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2025, 11, 14))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2025, 12, 14));

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2025, 1, 14))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2025, 2, 14));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않다() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2025, 1, 31))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2025, 2, 28));

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2025, 5, 31))
                        .payAmount(10_000)
                        .build()
                , LocalDate.of(2025, 6, 30));
    }

    @Test
    void 첫_납부일_일자가_만료일_일자와_다른_경우_만원_납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2025, 1, 31))
                .billingDate(LocalDate.of(2025, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2025, 3, 31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2025, 1, 30))
                .billingDate(LocalDate.of(2025, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2025, 3, 30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2025, 5, 31))
                .billingDate(LocalDate.of(2025, 6, 30))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData3, LocalDate.of(2025, 7, 31));
    }

    @Test
    void 이만원_이상_납부하는_경우_그에_비례해서_만료일_계산() {
        PayData payData = PayData.builder()
                .billingDate(LocalDate.of(2025, 1, 14))
                .payAmount(20_000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2025, 3, 14));

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2025, 1, 14))
                .payAmount(30_000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2025, 4, 14));
    }

    @Test
    void 첫_납부일_일자가_만료일_일자와_다른_경우_이만원_납부() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2025, 1, 31))
                        .billingDate(LocalDate.of(2025, 2, 28))
                        .payAmount(20_000)
                        .build(),

                LocalDate.of(2025, 4, 30));
    }

    private static void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate realExpiryDate = calculator.calculateExpiryDate(payData);

        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
