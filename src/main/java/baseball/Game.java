package baseball;

import baseball.model.Ball;

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

}
