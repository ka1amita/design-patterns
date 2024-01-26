package prototypes.own.shapes;

public abstract class Shape implements Cloneable {

  public String color;

  public Shape() {
  }

  public Shape(String color) {
    this.color = color;
  }

  @Override
  public Shape clone() throws CloneNotSupportedException {
    Shape clone = (Shape) super.clone();
    clone.color = this.color;
    return clone;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Shape shape) {
      return (this.color.equals(shape.color));
    }
    return false;
  }
}
