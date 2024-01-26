package prototypes.example.shapes;

public class Circle extends Shape {

  public int radius;

  public Circle() {
  }

  public Circle(Circle prototype) {
    super(prototype);
    this.radius = prototype.radius;
  }

  @Override
  public Shape clone() {
    return new Circle(this);
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Circle shape && super.equals(other)) {
      return (this.radius == shape.radius);
    } else {
      return false;
    }
  }
}
