package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    // 모든 기준을 충족할 경우, 암호 강도: Strong
    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
    }

    // 길이 기준만 충족하지 않는 경우, 암호 강도: Normal
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrength result = meter.meter("ab12!@C");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    // 숫자를 포함하는 기준만 충족하지 않는 경우, 암호 강도: Normal
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        PasswordStrength result = meter.meter("abcd!@EF");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
