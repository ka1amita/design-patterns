package abstract_factory.factories;

import abstract_factory.buttons.Button;
import abstract_factory.buttons.WindowsButton;
import abstract_factory.checkboxes.Checkbox;
import abstract_factory.checkboxes.WinCheckbox;

public class WindowsFactory extends GUIFactory {

  @Override
  public Button createButton() {
    return new WindowsButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new WinCheckbox();
  }
}
