package factory_method.factory;

import factory_method.buttons.Button;

public abstract class Dialog {

  protected abstract Button creaateButton();

  public void renderWindow() {
    Button button = creaateButton();
    button.render();
  }
}
