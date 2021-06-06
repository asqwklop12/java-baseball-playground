package baseball.util;

import java.util.List;

public class ScoreCalculator {

  public static String convert(int score) {
    return String.valueOf(score);
  }

  public static String[] split(String score) {
    return score.split("");
  }

  public static String action(List<String> score) {
    if (score.size() == 1) {
      return score.get(0) + "볼";
    }
    if (score.get(1).equals("0")) {
      return score.get(0) + "스트라이크";
    }
    return score.get(1) + "볼 " + score.get(0) + "스트라이크";
  }
}
