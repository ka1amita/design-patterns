package memento.nested;

import java.util.Stack;

public class TextEditorHistory {

  private final Stack<EditorCommand> commands = new Stack<>();

  public void push(EditorCommand command) {
    commands.push(command);
  }

  public EditorCommand pop() {
    return commands.pop();
  }
}
