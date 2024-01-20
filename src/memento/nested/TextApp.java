package memento.nested;

public class TextApp {

  private final TextEditor editor;

  private final TextEditorHistory history;

  public TextApp(TextEditor editor, TextEditorHistory history) {
    this.editor = editor;
    this.history = history;
  }

  public void type(String text) {
    TypeCommand command = new TypeCommand(history, editor, text);
    command.execute();
  }

  public String read() {
    return editor.getText();
  }

  public void undo() {
    history.pop().undo();
  }
}
