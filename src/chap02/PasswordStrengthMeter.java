package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        boolean lengthEnough = password.length() >= 8;
        boolean containsNumber = password.matches(".*\\d.*");
        boolean containsUpperCase = password.matches(".*[A-Z].*");

        if (lengthEnough && !containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough && containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough && !containsNumber && containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }

        if (!containsUpperCase) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
