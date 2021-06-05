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

  public int compare(List<Integer> computer, List<Integer> player) {
    return iterateComputer2(computer, player, 0, 0);
  }

  private int iterateComputer2(List<Integer> computer, List<Integer> player, int comCnt, int score) {
    if (computer.size() == comCnt) {
      return score;
    }
    score = iteratePlayer(computer, player, comCnt, 0, score);
    return iterateComputer2(computer, player, comCnt + 1, score);
  }

  private int iteratePlayer(List<Integer> computer, List<Integer> player, int comCnt, int playerCnt, int score) {
    if (player.size() == playerCnt) {
      return score;
    }
    if (compare(new Ball(comCnt + 1, computer.get(comCnt)), new Ball(playerCnt + 1, player.get(playerCnt))) == BallStatus.BALL) {
      score += 1;
    }
    if (compare(new Ball(comCnt + 1, computer.get(comCnt)), new Ball(playerCnt + 1, player.get(playerCnt))) == BallStatus.STRIKE) {
      score += 10;
    }
    return iteratePlayer(computer, player, comCnt, playerCnt + 1, score);
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
