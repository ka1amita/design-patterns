package factory_method.factory;

import factory_method.buttons.Button;
import factory_method.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

  @Override
  protected Button creaateButton() {
    return new WindowsButton();
  }
}
