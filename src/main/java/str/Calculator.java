package str;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

  List<Character> ops = new ArrayList<>();

  public Calculator() {
    ops.add('+');
    ops.add('*');
    ops.add('-');
    ops.add('/');
  }

  public int cal(String[] values) {
    int result = 0;
    char op = '+';
    for (int i = 0; i < values.length; i++) {
      if (i % 2 != 0) {
        op = values[i].charAt(0);
        wrongOperation(op);
        continue;
      }

      if (op == '+') {
        result += Integer.parseInt(values[i]);
      }
      if (op == '-') {
        result -= Integer.parseInt(values[i]);
      }
      if (op == '*') {
        result *= Integer.parseInt(values[i]);
      }
      if (op == '/') {
        result /= Integer.parseInt(values[i]);
      }
    }
    return result;
  }

  private void wrongOperation(char op) {
    if (!ops.contains(op)) {
      throw new IllegalArgumentException("잘못된 연산자가 들어갔습니다.");
    }
  }
}
