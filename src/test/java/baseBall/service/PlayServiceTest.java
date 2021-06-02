package baseBall.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseBall.model.Ball;
import baseBall.model.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayServiceTest {

  PlayService playService;

  @BeforeEach
  void init() {
    playService = new PlayService();
  }

  @Test
  @DisplayName("1볼일인 경우")
  void ballTest_1() {
    Ball compare = playService.compareAsBall(124, 456);
    assertThat(compare.increase()).isEqualTo(1);
  }

  @Test
  @DisplayName("2볼일인 경우")
  void ballTest_2() {
    Ball compare = playService.compareAsBall(145, 456);
    assertThat(compare.increase()).isEqualTo(2);
  }

  @Test
  @DisplayName("3볼일인 경우")
  void ballTest_3() {
    Ball compare = playService.compareAsBall(645, 456);
    assertThat(compare.increase()).isEqualTo(3);
  }

  @Test
  @DisplayName("1스트라이크 1볼인 경우 => 1볼이 나와야 한다.")
  void ballTest_4() {
    Ball compare = playService.compareAsBall(246, 456);
    assertThat(compare.increase()).isEqualTo(1);
  }

  @Test
  @DisplayName("1스트라이크인 경우")
  void strikeTest_1() {
    Strike compare = playService.compareAsStrike(123, 156);
    assertThat(compare.increase()).isEqualTo(1);
  }

  @Test
  @DisplayName("2스트라이크인 경우")
  void strikeTest_2() {
    Strike compare = playService.compareAsStrike(153, 156);
    assertThat(compare.increase()).isEqualTo(2);
  }

  @Test
  @DisplayName("3스트라이크인 경우")
  void strikeTest_3() {
    Strike compare = playService.compareAsStrike(156, 156);
    assertThat(compare.increase()).isEqualTo(3);
  }





}