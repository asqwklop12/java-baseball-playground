package baseBall.service;

import baseBall.model.Ball;
import baseBall.model.Computer;
import baseBall.model.Input;
import baseBall.model.Strike;
import baseBall.model.User;
import baseBall.ui.InputView;
import java.util.ArrayList;
import java.util.List;

public class PlayService {


  public Ball compareAsBall(int player, int com) {
    List<Integer> playerHasNumbers = IntegerMakeWithArray(player);
    List<Integer> computerHasNumbers = IntegerMakeWithArray(com);
    Ball ball = new Ball();
    for (int i = 0; i < computerHasNumbers.size(); i++) {
      iteratorPlayer(playerHasNumbers, computerHasNumbers, ball, i);
    }
    return ball;
  }

  public Strike compareAsStrike(int player, int com) {
    List<Integer> playerHasNumbers = IntegerMakeWithArray(player);
    List<Integer> computerHasNumbers = IntegerMakeWithArray(com);
    Strike strike = new Strike();
    for (int i = 0; i < computerHasNumbers.size(); i++) {
      increase(playerHasNumbers, computerHasNumbers, strike, i, i);
    }
    return strike;
  }


  private void iteratorPlayer(List<Integer> playerHasNumbers, List<Integer> computerHasNumbers,
      Ball ball, int i) {
    for (int j = 0; j < playerHasNumbers.size(); j++) {
      if (i != j) {
        increase(playerHasNumbers, computerHasNumbers, ball, i, j);
      }
    }
  }

  private void increase(List<Integer> numberSet1, List<Integer> numberSet2,
      Input get, int i, int j) {
    if (numberSet1.get(i).equals(numberSet2.get(j))) {
      get.increase();
    }
  }

  private List<Integer> IntegerMakeWithArray(int number) {
    List<Integer> numArray = new ArrayList<>();
    while (number > 0) {
      numArray.add(number % 10);
      number = number / 10;
    }
    return numArray;
  }



}
