package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        if (!password.matches(".*\\d.*")) {
            return PasswordStrength.NORMAL;
        }

        if (!password.matches(".*[A-Z].*")) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
