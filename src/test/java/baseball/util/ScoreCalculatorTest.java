package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {


  @Test
  void scoreTest() {
    assertThat(ScoreCalculator.action(12)).isEqualTo("2볼 1스트라이크");
    assertThat(ScoreCalculator.action(1)).isEqualTo("1볼");
    assertThat(ScoreCalculator.action(20)).isEqualTo("2스트라이크");
    assertThat(ScoreCalculator.action(0)).isEqualTo("낫싱");
  }

}
