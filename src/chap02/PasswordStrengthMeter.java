package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {

        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        if (getMetCriteriaCounts(password) <= 1) {
            return PasswordStrength.WEAK;
        }

        if (getMetCriteriaCounts(password) == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password) {
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

        return criteriaMatchCount;
    }
}
