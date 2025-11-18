package chap06;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private final String numbers;

    public BaseballGame(String numbers) {
        this.numbers = numbers;
        validateDuplicateNumbers(numbers);
    }

    public Score guess(String input) {
        if (numbers.equals(input)) {
            return new Score(3, 0);
        }

        return new Score(0, 0);
    }

    private void validateDuplicateNumbers(String input) {
        Set<String> set = new HashSet<>();
        for (String s : input.split("")) {
            if (!set.add(s)) {
                throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
            }
        }
    }
}
