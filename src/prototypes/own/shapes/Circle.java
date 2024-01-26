package prototypes.own.shapes;

public class Circle extends Shape {

  public int y;
  public int x;
  public int radius;

  public Circle() {
  }

  public Circle(String color, int x, int y, int radius) {
    super(color);
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @Override
  public Circle clone() throws CloneNotSupportedException {
    Circle clone = (Circle) super.clone();
    clone.x = this.x;
    clone.y = this.y;
    clone.radius = this.radius;
    return clone;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Circle circle) {
      return (this.x == circle.x &&
          this.y == circle.y &&
          this.radius == circle.radius &&
          super.equals(other));
    } else {
      return false;
    }
  }
}
