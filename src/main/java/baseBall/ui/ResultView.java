package baseBall.ui;

import baseBall.model.Ball;
import baseBall.model.Computer;
import baseBall.model.Strike;
import baseBall.model.User;
import baseBall.service.PlayService;

public class ResultView {


  public static void main(String[] args) {
    action();
  }

  public static void action() {
    Computer computer = InputView.numSetting();
    System.out.println(computer.output());
    playing(computer);
  }

  private static void playing(Computer computer) {
    PlayService playService = new PlayService();
    while (true) {
      System.out.print("숫자를 입력해주세요: ");
      User user = InputView.input();
      Ball ball = playService.compareAsBall(user.output(), computer.output());
      Strike strike = playService.compareAsStrike(user.output(), computer.output());
      printBallOrStrike(ball, strike);
      over(strike);
      ball.init(0);
      strike.init(0);
    }
  }

  private static void over(Strike strike) {
    if (strike.getCnt() == 3) {
      System.out.println("3개의 숫자를 모두 맞추셨습니다. 게임 종료");
      System.out.println("게임을 새롭게 시작하려면 1, 종료하려면 2를 입력하세요.");
      reStart(InputView.checkNumber());
    }
  }

  private static void reStart(int num) {
    if (num == 1) {
      action();
    }
    if (num == 2) {
      System.exit(0);
    }
  }

  private static void printBallOrStrike(Ball ball, Strike strike) {
    if (ball.increase() == 0) {
      System.out.println(strike.getCnt() + "스트라이크");
      return;
    }
    if (strike.increase() == 0) {
      System.out.println(ball.getCnt() - 1 + "볼");
      return;
    }
    System.out.println((ball.getCnt() - 1) + "볼" + " " + (strike.getCnt() - 1) + "스트라이크");
  }
}
