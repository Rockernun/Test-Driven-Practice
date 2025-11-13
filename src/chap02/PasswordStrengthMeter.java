package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int criteriaMatchCount = 0;

        if (password.length() >= 8) {
            criteriaMatchCount++;
        }

        if (password.matches(".*\\d.*")) {
            criteriaMatchCount++;
        }

        if (password.matches(".*[A-Z].*")) {
            criteriaMatchCount++;
        }

        if (criteriaMatchCount == 1) {
            return PasswordStrength.WEAK;
        }

        if (criteriaMatchCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
