package baseball.ui;

import baseball.Referee;
import baseball.model.Hitter;
import baseball.model.Pitcher;
import baseball.util.ScoreCalculator;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final String INPUT_NUMBER = "숫자를 입력해 주세요 : ";

  private static List<Integer> pitch() {
    return new Pitcher().pitch();
  }

  private static List<Integer> hit() {
    return new Hitter().hit();
  }

  public static boolean play() {
    System.out.print(INPUT_NUMBER);
    List<Integer> pitch = pitch();
    System.out.println(pitch);
    Referee referee = new Referee(pitch, hit());
    String action = ScoreCalculator.action(referee.compare());
    System.out.println(action);
    while (!action.equals("3스트라이크")) {
      System.out.print(INPUT_NUMBER);
      referee.input(hit());
      System.out.println(ScoreCalculator.action(referee.compare()));
    }
    System.out.println("3개의 숫자를 모두 맞추셨습니다. 게임 종료");
    return finish();
  }

  private static boolean finish() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt() == 2;
  }
}
