package memento.nested;

public interface EditorCommand {

  boolean execute();

  void undo();
}
