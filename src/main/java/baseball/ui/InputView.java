package baseball.ui;

import baseball.Referee;
import baseball.model.Hitter;
import baseball.model.Pitcher;
import java.util.List;

public class InputView {

  private static List<Integer> pitch() {
    return new Pitcher().pitch();
  }

  private static List<Integer> hit() {
    return new Hitter().hit();
  }

  public void play() {
    List<Integer> pitcher = pitch();
    System.out.print("숫자를 입력해 주세요 : ");
    List<Integer> hitter = hit();
    Referee referee = new Referee(pitcher, hitter);
    int score = referee.compare();
  }
}
