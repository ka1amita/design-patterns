package abstract_factory.factories;

import abstract_factory.buttons.Button;
import abstract_factory.checkboxes.Checkbox;

public abstract class GUIFactory {

  public abstract Button createButton();

  public abstract Checkbox createCheckbox();
}
