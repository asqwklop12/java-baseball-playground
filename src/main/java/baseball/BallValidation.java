package baseball;

public class BallValidation {

  private static final int MIN = 1;
  private static final int MAX = 9;

  public static boolean range(int num) {
    return MIN <= num && num <= MAX;
  }
}
