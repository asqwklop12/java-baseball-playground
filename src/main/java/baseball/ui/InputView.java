package baseball.ui;

import baseball.model.Pitcher;
import java.util.List;

public class InputView {

  public static List<Integer> pitch() {
    return new Pitcher().readyNumbers();
  }
}
