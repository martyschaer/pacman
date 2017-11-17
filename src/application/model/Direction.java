package application.model;

import application.model.elements.Point;

public enum Direction {
  UP(new Point(0,-1), 90),
  DOWN(new Point(0,1), 270),
  LEFT(new Point(-1,0), 180),
  RIGHT(new Point(1,0), 0);

  private Point value;
  private double angle;

  Direction(Point value, double angle) {
    this.value = value;
    this.angle = angle;
  }

  public Point getValue() {
    return value;
  }

  public double getAngle(){
    return angle;
  }
}
