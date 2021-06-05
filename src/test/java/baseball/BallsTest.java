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

}
