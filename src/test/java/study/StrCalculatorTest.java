package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import str.Calculator;

public class StrCalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void equals() {
    String value = "1";
    String[] values = value.split(" ");
    int number = Integer.parseInt(values[0]);
    assertThat(number).isEqualTo(1);
  }

  @Test
  void add_v1() {
    String value = "1 + 2";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(3);
  }

  @Test
  void add_v2() {
    String value = "1 + 2 + 5";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(8);
  }

  @Test
  void add_v3() {
    String value = "1 + 2 + 5 + 7";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(15);
  }

  @Test
  void sub_v1() {
    String value = "1 - 5";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(-4);
  }

  @Test
  void sub_v2() {
    String value = "1 - 5 - 7";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(-11);
  }

  @Test
  void mul_v1() {
    String value = "1 * 5";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(5);
  }

  @Test
  void div_v1() {
    String value = "1 / 5";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(0);
  }

  @Test
  void div_v2() {
    assertThatThrownBy(() -> {
      String value = "1 / 0";
      String[] values = value.split(" ");
      int number = calculator.cal(values);
      throw new ArithmeticException();
    }).isInstanceOf(ArithmeticException.class)
        .hasMessageContaining("/ by zero");
  }

  @Test
  void mix_v1() {
    String value = "1 * 2 + 5 / 7";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(1);
  }

  @Test
  void mix_v2() {
    String value = "1 - 2 + 5 / 2";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(2);
  }

  @Test
  void mix_v3() {
    String value = "1 - 2 - 5 / 2";
    String[] values = value.split(" ");
    int number = calculator.cal(values);
    assertThat(number).isEqualTo(-3);
  }

  @Test
  void error() {
    assertThatThrownBy(() -> {
      String value = "1 k 2 - 5 / 2";
      String[] values = value.split(" ");
      calculator.cal(values);
      throw new IllegalArgumentException();
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘못된 연산자가 들어갔습니다.");

  }






}
