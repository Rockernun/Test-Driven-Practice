package chap06;

public class BaseballGame {

    private final String numbers;

    public BaseballGame(String numbers) {
        this.numbers = numbers;
    }

    public Score guess(String input) {
        if (numbers.equals(input)) {
            return new Score(3, 0);
        }

        return new Score(0, 0);
    }
}
