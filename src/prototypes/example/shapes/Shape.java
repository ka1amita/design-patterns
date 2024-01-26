package prototypes.example.shapes;

public abstract class Shape {

  public int x;
  public int y;
  public String color;

  public Shape() {
  }

  public Shape(Shape prototype) {
    this.x = prototype.x;
    this.y = prototype.y;
    this.color = prototype.color;
  }

  public abstract Shape clone();

  @Override
  public boolean equals(Object other) {
    if (other instanceof Shape shape) {
      return (this.x == shape.x && this.y == shape.y && this.color.equals(shape.color));
    } else {
      return false;
    }
  }
}
