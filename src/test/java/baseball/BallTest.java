package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Ball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

  private Game game;

  @BeforeEach
  void setUp() {
    this.game = new Game();
  }

  @Test
  @DisplayName("위치와 숫자 모두 틀릴때")
  void notting() {
    assertThat(game.compare(new Ball(1, 1), new Ball(2, 5))).isEqualTo(BallStatus.NOTTING);
  }

  @Test
  @DisplayName("숫자는 같은데 위치가 다를 때 ")
  void ball() {
    assertThat(game.compare(new Ball(1, 1), new Ball(2, 1))).isEqualTo(BallStatus.BALL);
  }

  @Test
  @DisplayName("숫자 와 위치 모두 같을 때")
  void strike() {
    assertThat(game.compare(new Ball(2, 1), new Ball(2, 1))).isEqualTo(BallStatus.STRIKE);
  }


}
