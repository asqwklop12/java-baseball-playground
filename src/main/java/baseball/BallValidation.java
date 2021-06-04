package baseball;

import java.util.List;

public class BallValidation {

  private static final int MIN = 1;
  private static final int MAX = 9;
  private static final int TOTAL_BASEBALL_CNT = 3;


  public static boolean range(int num) {
    return MIN <= num && num <= MAX;
  }

  public static boolean size(List<Integer> nums) {
    return nums.size() == TOTAL_BASEBALL_CNT;
  }
}
