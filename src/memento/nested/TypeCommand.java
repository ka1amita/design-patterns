package memento.nested;

public class TypeCommand implements EditorCommand {

  private final TextEditor receiver;
  private final String textToType;
  private final TextEditorHistory history;
  private Memento backup;

  public TypeCommand(TextEditorHistory history, TextEditor receiver, String textToType) {
    this.receiver = receiver;
    this.textToType = textToType;
    this.history = history;
  }

  @Override
  public boolean execute() {
    backup = receiver.save();
    history.push(this);

    receiver.setText(textToType);
    return true;
  }

  @Override
  public void undo() {
    backup.restore();
  }
}
