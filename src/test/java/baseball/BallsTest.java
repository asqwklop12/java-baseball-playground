package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {


  @Test
  @DisplayName("볼일 경우 숫자 3개 비교")
  void ballCompare3Test() {
    Game game = new Game(Arrays.asList(1, 2, 3), Arrays.asList(4, 1, 5));
    assertThat(game.compare()).isEqualTo(1);
    game.input(Arrays.asList(2, 1, 5));
    assertThat(game.compare()).isEqualTo(2);
    game.input(Arrays.asList(2, 3, 1));
    assertThat(game.compare()).isEqualTo(3);
  }

  @Test
  @DisplayName("스트라이크일 경우 숫자 3개 비교")
  void strikeCompare3Test() {
    Game game = new Game(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5));
    assertThat(game.compare()).isEqualTo(10);
    game.input(Arrays.asList(1, 2, 5));
    assertThat(game.compare()).isEqualTo(20);
    game.input(Arrays.asList(1, 2, 3));
    assertThat(game.compare()).isEqualTo(30);
  }

  @Test
  @DisplayName("낫싱 테스트")
  void nottingTest() {
    Game game = new Game(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
    assertThat(game.compare()).isEqualTo(0);
  }
  @Test
  @DisplayName("복합 테스트")
  void compareTest() {
    Game game = new Game(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5));
    assertThat(game.compare()).isEqualTo(10);
    game.input(Arrays.asList(1, 5, 2));
    assertThat(game.compare()).isEqualTo(11);
    game.input(Arrays.asList(4, 2, 3));
    assertThat(game.compare()).isEqualTo(20);

  }

}
