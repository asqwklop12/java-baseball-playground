package baseball;

import baseball.model.Ball;
import java.util.List;

public class Game {

  public BallStatus compare(Ball player, Ball computer) {
    if (player.getNum() == computer.getNum() && player.getPosition() == computer.getPosition()) {
      return BallStatus.STRIKE;
    }
    if (player.getNum() == computer.getNum()) {
      return BallStatus.BALL;
    }
    return BallStatus.NOTTING;
  }

  public int compare(List<Integer> computer, Ball player) {
    return iterateComputer(computer, player, 0, 0);
  }


  private int iterateComputer(List<Integer> computer, Ball player, int cnt, int score) {
    if (cnt == computer.size()) {
      return score;
    }
    if (compare(new Ball(cnt + 1, computer.get(cnt)), player) == BallStatus.BALL) {
      score += 1;
    }
    if (compare(new Ball(cnt + 1, computer.get(cnt)), player) == BallStatus.STRIKE) {
      score += 10;
    }
    return iterateComputer(computer, player, cnt += 1, score);
  }

}
