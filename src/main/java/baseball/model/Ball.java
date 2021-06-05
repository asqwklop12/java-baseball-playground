package baseball.model;

public class Ball {

  private int position;
  private int num;

  public Ball(int position, int num) {
    this.position = position;
    this.num = num;
  }

  public int getNum() {
    return num;
  }

  public int getPosition() {
    return position;
  }
}
