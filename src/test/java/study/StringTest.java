package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void replace() {
    String actual = "abc".replace("b", "d");
    assertThat(actual).isEqualTo("adc");
  }

  @Test
  void split_1() {
    String[] actual = "1,2".split(",");
    assertThat(actual).contains("1", "2");
  }

  @Test
  void split_2() {
    String[] actual = "1".split(",");
    assertThat(actual).containsExactly("1");
  }

  @Test
  void substring() {
    String actual = "(1,2)".substring(1, "(1,2)".length() - 1);
    assertThat(actual).isEqualTo("1,2");
  }

  @Test
  @DisplayName("범위를 벗어날 경우")
  void charAt_1() {
    assertThatThrownBy(() -> {
      throw new StringIndexOutOfBoundsException("abc".charAt(2));
    }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 100");
  }

  @Test
  @DisplayName("범위를 벗어날 경우")
  void charAt_2() {
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
          throw new StringIndexOutOfBoundsException("abc".charAt(100));
        }).withMessageContaining("String index out of range: 100");
  }
}
