package chap06;

public class Score {

    private final int strikes;
    private final int balls;

    public Score(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int strikes() {
        return strikes;
    }

    public int balls() {
        return balls;
    }
}
