package baseBall.model;

public class Input {

  protected int cnt;

  public int increase() {
    return this.cnt++;
  }

  public void init(int cnt) {
    this.cnt = cnt;
  }

  public int getCnt() {
    return cnt;
  }
}
