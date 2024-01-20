package memento.nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TextAppTest {

  private TextEditor editor;
  private TextEditorHistory history;

  @BeforeEach
  public void setUp() {
    editor = new TextEditor();
    history = new TextEditorHistory();
  }


  @Test
  public void test_context() {
  }

  @Test
  public void set_editors_text() {
    editor.setText("text");

    assertEquals("text", editor.getText());
  }

  @Test
  public void TypeCommand_sets_text() {
    EditorCommand command = new TypeCommand(history, editor, "text");

    assertTrue(command.execute());
    assertEquals("text", editor.getText());
  }

  @Test
  public void TypeCommand_is_stored_in_History() {
    EditorCommand command = new TypeCommand(history, editor, "text");
    command.execute();

    EditorCommand historicCommand = history.pop();
    assertSame(historicCommand, command);
  }

  @Test
  public void undo_a_TypeCommand() {
    editor.setText("original");
    EditorCommand command = new TypeCommand(history, editor, "new");
    command.execute();
    assert editor.getText().equals("new");

    command.undo();

    assertEquals("original", editor.getText());
  }

  @Nested
  class AppTest {

    TextApp app;

    @BeforeEach
    public void setUp() {
      app = new TextApp(editor, history);
    }

    @Test
    public void type_twice_and_undo_twice_using_app() {
      app.type("original");
      assertEquals("original", app.read());
      app.type("new");
      assertEquals("new", app.read());
      app.undo();
      assertEquals("original", app.read());
      app.undo();
      assertTrue(app.read().isEmpty());
    }
  }
}
