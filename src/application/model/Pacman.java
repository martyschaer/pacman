package application.model;

import static application.model.Utils.UNIT;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Pacman {
  private Point position;
  private Direction direction;
  private final double STEP_SIZE = 1;
  private final Color COLOR = new Color(1, 0.8, 0, 1);
  private double mouthAngle = 0;
  private boolean opening = true;

  public Pacman(Point initialPos, Direction initialDir){
    this.position = initialPos;
    this.direction = initialDir;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void move(){
    int newX = position.x;
    int newY = position.y;
    newX += direction.getValue().x * STEP_SIZE;
    newY += direction.getValue().y * STEP_SIZE;
    this.position.setLocation(newX, newY);
  }

  public void draw(GraphicsContext ctx){
    nomnom();
    ctx.setFill(this.COLOR);
    ctx.fillArc(position.x * UNIT, position.y * UNIT, UNIT, UNIT, calculateMouthStartAngle(), 360-this.mouthAngle, ArcType.ROUND);
  }

  private void nomnom(){
    if(this.mouthAngle > 60){
      this.opening = false;
    }else if(this.mouthAngle < 0){
      this.opening = true;
    }

    if(opening){
      this.mouthAngle += 9;
    }else{
      this.mouthAngle -= 9;
    }
  }

  private double calculateMouthStartAngle(){
    return this.direction.getAngle()+this.mouthAngle/2;
  }
}
