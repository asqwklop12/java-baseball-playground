package baseball.model;

import baseball.BallValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pitcher {

  public List<Integer> pitch() {
    return duplicateValidation(readyNumbers(new ArrayList<>()));
  }

  private List<Integer> readyNumbers(List<Integer> nums) {
    while (!BallValidation.size(nums)) {
      rangeValidation(nums, generateRandomNumber());
    }
    return nums;
  }

  private List<Integer> duplicateValidation(List<Integer> nums) {
    nums.clear();
    readyNumbers(nums);
    if (!BallValidation.duplicate(nums)) {
      return nums;
    }
    return duplicateValidation(nums);
  }

  private void rangeValidation(List<Integer> nums, int num) {
    if (BallValidation.range(num)) {
      nums.add(num);
    }
  }

  private int generateRandomNumber() {
    return new Random().nextInt(8) + 1;
  }
}
