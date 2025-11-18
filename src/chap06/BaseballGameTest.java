package chap06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballGameTest {

    @Test
    void exactMatch() {
        // 정답이 456인 상황 (given)
        BaseballGame game = new BaseballGame("456");

        // 실행 (when)
        Score score = game.guess("456");

        // 결과 확인 (then)
        assertEquals(3, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void noMatch() {
        // 정답이 123인 상황 (given)
        BaseballGame game = new BaseballGame("123");

        // 실행 (when)
        Score score = game.guess("456");

        // 결과 확인 (then)
        assertEquals(0, score.strikes());
        assertEquals(0, score.balls());
    }
}
