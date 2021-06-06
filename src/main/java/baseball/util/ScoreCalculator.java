package baseball.util;

public class ScoreCalculator {


  public static String action(int score) {
    String[] result = split(convert(score));
    if (result.length == 1) {
      return result[0] + "볼";
    }
    if (result[1].equals("0")) {
      return result[0] + "스트라이크";
    }
    return result[1] + "볼 " + result[0] + "스트라이크";
  }

  private static String convert(int score) {
    return String.valueOf(score);
  }

  private static String[] split(String score) {
    return score.split("");
  }
}
