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

  public static boolean duplicate(List<Integer> nums) {
    return level(nums, 0);
  }

  private static boolean level(List<Integer> nums, int cur) {
    if (nums.size() - 1 == cur) {
      return false;
    }
    if (compare(nums, nums.get(cur), cur + 1)) {
      return true;
    }
    return level(nums, cur + 1);
  }

  private static boolean compare(List<Integer> nums, Integer value, int next) {
    if (value.equals(nums.get(next))) {
      return true;
    }

    if (nums.size() - 1 == next) {
      return false;
    }
    return compare(nums, value, next + 1);
  }

}
