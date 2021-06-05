package baseball;

import baseball.model.Ball;
import java.util.List;

public class Game {

  private static final int BASEBALL_MAX_COUNT = 3;
  private List<Integer> computerNums;
  private List<Integer> playerNums;

  public Game() {
  }

  public Game(List<Integer> computerNums, List<Integer> playerNums) {
    this.computerNums = computerNums;
    this.playerNums = playerNums;
  }

  public void input(List<Integer> playerNums) {
    this.playerNums = playerNums;
  }


  public BallStatus compare(Ball player, Ball computer) {
    if (player.getNum() == computer.getNum() && player.getPosition() == computer.getPosition()) {
      return BallStatus.STRIKE;
    }
    if (player.getNum() == computer.getNum()) {
      return BallStatus.BALL;
    }
    return BallStatus.NOTTING;
  }


  public int compare() {
    return iterateComputer(0, 0);
  }

  private int iterateComputer(int cnt, int score) {
    if (cnt == BASEBALL_MAX_COUNT) {
      return score;
    }
    return iterateComputer(cnt + 1, iteratePlayer(cnt, 0, score));
  }

  private int iteratePlayer(int com, int cnt, int score) {
    if (cnt == BASEBALL_MAX_COUNT) {
      return score;
    }

    Ball computer = new Ball(com + 1, computerNums.get(com));
    Ball player = new Ball(cnt + 1, playerNums.get(cnt));

    if (compare(computer, player) == BallStatus.BALL) {
      score += 1;
    }
    if (compare(computer, player) == BallStatus.STRIKE) {
      score += 10;
    }
    return iteratePlayer(com, cnt + 1, score);
  }

}
