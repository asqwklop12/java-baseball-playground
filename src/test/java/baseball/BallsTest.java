package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Ball;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

  Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
  }


  @Test
  @DisplayName("낫싱일 경우")
  void nottingTest() {
    assertThat(game.compare(Arrays.asList(1, 2, 3), new Ball(1, 8))).isEqualTo(0);
  }

  @Test
  @DisplayName("볼일 경우")
  void ballTest() {
    assertThat(game.compare(Arrays.asList(1, 2, 3), new Ball(1, 3))).isEqualTo(1);
  }

  @Test
  @DisplayName("스트라이크일 경우")
  void strikeTest() {
    assertThat(game.compare(Arrays.asList(1, 2, 3), new Ball(1, 1))).isEqualTo(10);
  }

  @Test
  @DisplayName("볼일 경우 숫자 3개 비교")
  void ballCompare3Test() {
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(4, 1, 5))).isEqualTo(1);
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 5))).isEqualTo(2);
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1))).isEqualTo(3);
  }

  @Test
  @DisplayName("스트라이크일 경우 숫자 3개 비교")
  void strikeCompare3Test() {
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5))).isEqualTo(10);
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 5))).isEqualTo(20);
    assertThat(game.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3))).isEqualTo(30);
  }


}
