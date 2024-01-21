package state.inner;

import state.inner.ui.Player;
import state.inner.ui.UI;

public class Demo {

  public static void main(String[] args) {
    Player player = new Player();
    UI ui = new UI(player);
    ui.init();
  }
}
