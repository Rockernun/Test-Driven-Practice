package chap05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    public LifeCycleTest() {
        System.out.println("new LifeCycleTest");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("a");
    }

    @Test
    void b() {
        System.out.println("b");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}

/**
 * <실행 결과>
 * new LifeCycleTest
 * setUp
 * a
 * tearDown
 * new LifeCycleTest
 * setUp
 * b
 * tearDown
 */
