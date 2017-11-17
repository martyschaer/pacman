package application.model.elements;

public class Point {
  private double x;
  private double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public void setLocation(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double x() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double y() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
}
