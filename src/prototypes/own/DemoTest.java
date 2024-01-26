package prototypes.own;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prototypes.own.shapes.Circle;

public class DemoTest {

  private Circle instance1;
  private Circle instance2;

  @BeforeEach
  void setUp() {
    instance1 = new Circle("red", 1, 1, 1);
    instance2 = new Circle("red", 1, 1, 1);
  }

  @Test
  public void equal_instances_equal() {
    assertEquals(instance1, instance2);
  }

  @Test
  public void non_equal_color_instances_doesnt_equal() {
    instance2.color = "blue";

    assertNotEquals(instance1, instance2);
  }

  @Test
  public void non_equal_x_instances_doesnt_equal() {
    instance2.x = 2;

    assertNotEquals(instance1, instance2);
  }

  @Test
  public void non_equal_y_instances_doesnt_equal() {
    instance2.y = 2;

    assertNotEquals(instance1, instance2);
  }

  @Test
  public void non_equal_radius_instances_doesnt_equal() {
    instance2.radius = 2;

    assertNotEquals(instance1, instance2);
  }

  @Test
  public void cloned_instances_equal() throws CloneNotSupportedException {
    instance2 = instance1.clone();

    assertNotSame(instance1, instance2);
    assertEquals(instance1, instance2);
  }
}
