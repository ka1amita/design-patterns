package abstract_factory.factories;

import abstract_factory.buttons.Button;
import abstract_factory.buttons.MacOsButton;
import abstract_factory.checkboxes.Checkbox;
import abstract_factory.checkboxes.MacOsCheckbox;

public class MacOSFactory extends GUIFactory {

  @Override
  public Button createButton() {
    return new MacOsButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new MacOsCheckbox();
  }
}
