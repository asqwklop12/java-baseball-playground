package baseball.ui;

import baseball.BallValidation;
import java.util.List;

public class ResultView {

  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
    List<Integer> pitch = InputView.pitch();
      if(BallValidation.duplicate(pitch)) {
        System.out.println("중복된게 존재합니다.");
        System.out.println(pitch);
      }

    }
  }
}
