package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class BallValidationTest {

  @Test
  void _0부터9까지숫자인가() {
    assertThat(BallValidation.range(1)).isTrue();
    assertThat(BallValidation.range(0)).isFalse();
    assertThat(BallValidation.range(5)).isTrue();
    assertThat(BallValidation.range(10)).isFalse();
  }

  @Test
  void _3자리_숫자인가() {
    assertThat(BallValidation.size(Arrays.asList(1, 2, 3))).isTrue();
    assertThat(BallValidation.size(Collections.singletonList(1))).isFalse();
    assertThat(BallValidation.size(Collections.emptyList())).isFalse();
    assertThat(BallValidation.size(Arrays.asList(1, 2, 3, 4))).isFalse();
  }

  @Test
  void 중복된_숫자인가() {
    assertThat(BallValidation.duplicate(Arrays.asList(1, 1, 2))).isTrue();
    assertThat(BallValidation.duplicate(Arrays.asList(1, 2, 1))).isTrue();
    assertThat(BallValidation.duplicate(Arrays.asList(2, 1, 1))).isTrue();
    assertThat(BallValidation.duplicate(Arrays.asList(1, 1, 1))).isTrue();
    assertThat(BallValidation.duplicate(Arrays.asList(1, 2, 3))).isFalse();
  }
}
