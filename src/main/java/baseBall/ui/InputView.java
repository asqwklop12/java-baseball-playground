package baseBall.ui;

import baseBall.model.Computer;
import baseBall.model.User;
import java.util.Random;
import java.util.Scanner;

public class InputView {

  static Scanner scanner = new Scanner(System.in);

  public static int checkNumber() {
    return scanner.nextInt();
  }

  public static User input() {
    User user = new User();
    int num = scanner.nextInt();
    wrongRange(num);
    user.input(checkNum(num));
    return user;
  }

  private static int checkNum(int num) {
    String temp = String.valueOf(num);
    int a = temp.charAt(0);
    int b = temp.charAt(1);
    int c = temp.charAt(2);

    if (a == b || a == c || b == c) {
      int reInput = scanner.nextInt();
      wrongRange(reInput);
      return checkNum(reInput);
    }
    return num;
  }


  private static void wrongRange(int num) {
    if (0 >= num || num > 999) {
      throw new IllegalArgumentException("범위를 벗어났습니다.");
    }
  }

  public static Computer numSetting() {
    Computer computer = new Computer();
    Random random = new Random();
    int a = (random.nextInt(8) + 1);
    int b = (random.nextInt(8) + 1);
    int c = random.nextInt(8) + 1;
    b = re(random, a, b);
    c = re(random, a, c);
    c = re(random, b, c);
    computer.input(a * 100 + b * 10 + c);
    return computer;
  }

  private static int re(Random random, int number1, int number2) {
    while (number1 == number2) {
      number2 = (random.nextInt(8) + 1);
    }
    return number2;
  }
}
