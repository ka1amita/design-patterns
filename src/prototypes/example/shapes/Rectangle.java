package prototypes.example.shapes;

public class Rectangle extends Shape {

  public int width;
  public int height;

  public Rectangle() {
  }

  public Rectangle(Rectangle prototype) {
    super(prototype);
    this.width = prototype.width;
    this.height = prototype.height;
  }

  @Override
  public Shape clone() {
    return new Rectangle(this);
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Rectangle rectangle && super.equals(other)) {
      return (this.height == rectangle.height && this.width == rectangle.width);
    } else {
      return false;
    }
  }
}
