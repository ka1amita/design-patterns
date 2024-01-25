package abstract_factory.app;

import abstract_factory.buttons.Button;
import abstract_factory.checkboxes.Checkbox;
import abstract_factory.factories.GUIFactory;

public class Application {

  private final GUIFactory factory;
  private Button button;
  private Checkbox checkbox;

  public Application(GUIFactory factory) {
    this.factory = factory;
  }

  public void paint() {
    button = factory.createButton();
    checkbox = factory.createCheckbox();
    button.paint();
    checkbox.paint();
  }
}
