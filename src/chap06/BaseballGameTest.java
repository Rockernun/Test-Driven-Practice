package chap06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballGameTest {

    private BaseballGame game;

    @BeforeEach
    void givenGame() {
        game = new BaseballGame("456");
    }

    @Test
    void exactMatch() {
        // 실행 (when)
        Score score = game.guess("456");

        // 결과 확인 (then)
        assertEquals(3, score.strikes());
        assertEquals(0, score.balls());
    }

    @Test
    void noMatch() {
        // 실행 (when)
        Score score = game.guess("123");

        // 결과 확인 (then)
        assertEquals(0, score.strikes());
        assertEquals(0, score.balls());
    }
}
