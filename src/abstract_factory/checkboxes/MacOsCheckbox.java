package abstract_factory.checkboxes;

public class MacOsCheckbox implements Checkbox {

  @Override
  public void paint() {
    System.out.println("You have created MacOsCheckbox.");
  }
}
