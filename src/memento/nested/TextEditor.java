package memento.nested;

public class TextEditor {

  private String text = "";

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Memento save() {
    return new Snapshot(this, text);
  }

  private static class Snapshot implements Memento {

    private final TextEditor editor;
    private final String text;

    public Snapshot(TextEditor editor, String text) {
      this.editor = editor;
      this.text = text;
    }

    @Override
    public void restore() {
      editor.setText(text);
    }
  }
}
