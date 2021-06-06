package baseball.model;

import baseball.BallValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hitter implements AutoCloseable {

  private final Scanner scanner;

  public Hitter() {
    scanner = new Scanner(System.in);
  }

  public List<Integer> hit() {
    List<Integer> nums = new ArrayList<>();
    while (!BallValidation.size(nums)) {
      int num = rangeValidation(crateNumber());
      nums.add(num);
      duplicateValidation(nums, num);
    }
    return nums;
  }

  private int rangeValidation(int num) {
    if (!BallValidation.range(num)) {
      return crateNumber();
    }
    return num;
  }

  private List<Integer> duplicateValidation(List<Integer> nums, int num) {
    if (BallValidation.duplicate(nums)) {
      nums.remove(num);
      nums.add(rangeValidation(crateNumber()));
      return duplicateValidation(nums, num);
    }
    return nums;
  }


  private int crateNumber() {
    return scanner.nextInt();
  }

  @Override
  public void close() throws Exception {
    scanner.close();
  }
}
