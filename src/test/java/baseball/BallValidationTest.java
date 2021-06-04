package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BallValidationTest {

  @Test
  void _0부터9까지숫자인가() {
    assertThat(BallValidation.range(1)).isTrue();
    assertThat(BallValidation.range(0)).isFalse();
    assertThat(BallValidation.range(5)).isTrue();
    assertThat(BallValidation.range(10)).isFalse();
  }
}
