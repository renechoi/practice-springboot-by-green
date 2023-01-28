package day4.theater;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TheaterTest {
    @Test
    void createTest() {
        assertThatCode(() -> new Theater(
                "메가박스",
                new Seat("홍길동"),
                new Seat("김길동"),
                new Seat("박길동")))
                .doesNotThrowAnyException();
    }
}