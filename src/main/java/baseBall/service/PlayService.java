package baseBall.service;

import baseBall.model.Computer;
import baseBall.model.User;
import baseBall.ui.InputView;

public class PlayService {

  private User user;
  private Computer computer;

  public void init() {
    user = InputView.input();
    computer = InputView.numSetting();
  }

  public void print() {
    System.out.println(user.output());
    System.out.println(computer.output());
  }
}
