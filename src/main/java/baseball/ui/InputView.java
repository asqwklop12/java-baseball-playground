package baseball.ui;

import baseball.model.Hitter;
import baseball.model.Pitcher;
import java.util.List;

public class InputView {

  public static List<Integer> pitch() {
    return new Pitcher().pitch();
  }

  public static List<Integer> hit() {
    return new Hitter().hit();
  }
}
