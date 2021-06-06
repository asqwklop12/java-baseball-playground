package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {

  @Test
  void convertScore() {
    String score = ScoreCalculator.convert(10);
    assertThat(score).isEqualTo("10");
  }

  @Test
  void splitScore() {
    String[] score = ScoreCalculator.split("12");
    assertThat(score).contains("1", "2");
  }

  @Test
  void scoreTest() {
    assertThat(ScoreCalculator.action(Arrays.asList("1", "2"))).isEqualTo("2볼 1스트라이크");
    assertThat(ScoreCalculator.action(Collections.singletonList("1"))).isEqualTo("1볼");
    assertThat(ScoreCalculator.action(Arrays.asList("2", "0"))).isEqualTo("2스트라이크");
  }

}
