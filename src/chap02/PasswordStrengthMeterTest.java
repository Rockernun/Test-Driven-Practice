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

    // 대문자를 포함하는 기준만 충족하지 않는 경우, 암호 강도: Normal
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("abcd1234", PasswordStrength.NORMAL);
    }

    // 길이 기준만 충족한 경우, 암호 강도: Weak
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("!@#$%^&*", PasswordStrength.WEAK);
    }

    // 숫자를 포함하는 기준만 충족한 경우, 암호 강도: Weak
    @Test
    void meetsOnlyNumberCriteria_Then_Weak() {
        assertStrength("1234", PasswordStrength.WEAK);
    }

    // 대문자를 포함하는 기준만 충족한 경우, 암호 강도: Weak
    @Test
    void meetsOnlyUppercaseCriteria_Then_Weak() {
        assertStrength("ABCD", PasswordStrength.WEAK);
    }

    // 아무 기준도 충족하지 않는 경우, 암호 강도: Weak
    @Test
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }

    // 암호가 입력되지 않는 경우, 암호 강도: INVALID
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
        assertStrength("", PasswordStrength.INVALID);
    }

    private void assertStrength(String password, PasswordStrength strength) {
        PasswordStrength result = meter.meter(password);
        assertEquals(strength, result);
    }
}
