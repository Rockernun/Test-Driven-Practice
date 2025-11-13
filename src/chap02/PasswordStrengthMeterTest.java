package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    // 모든 기준을 충족할 경우, 암호 강도: Strong
    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }

    // 길이 기준만 충족하지 않는 경우, 암호 강도: Normal
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@C", PasswordStrength.NORMAL);
    }

    // 숫자를 포함하는 기준만 충족하지 않는 경우, 암호 강도: Normal
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("abcd!@EF", PasswordStrength.NORMAL);
    }

    private void assertStrength(String password, PasswordStrength strength) {
        PasswordStrength result = meter.meter(password);
        assertEquals(strength, result);
    }
}
