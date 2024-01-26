package prototypes.own.shapes;

public class Rectangle extends Shape {

  public int width;
  public int height;

  @Override
  public boolean equals(Object other) {
    if (other instanceof Rectangle circle) {
      return (this.width == circle.width &&
          this.height == circle.height &&
          super.equals(other));
    } else {
      return false;
    }
  }
}
