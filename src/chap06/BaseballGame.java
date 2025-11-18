package chap06;

public class BaseballGame {

    private String numbers;

    public BaseballGame(String numbers) {
        this.numbers = numbers;
    }

    public Score guess(String input) {
        return new Score();
    }
}
