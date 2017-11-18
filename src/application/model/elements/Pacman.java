package application.model.elements;

import static application.model.Utils.UNIT;

import application.model.Direction;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

public class Pacman {
  private Point position;
  private Direction direction;
  private final double STEP_SIZE = 1;
  private final Color COLOR = new Color(1, 0.8, 0, 1);
  private double mouthAngle = 0;
  private boolean opening = true;
  private double extent = (double)UNIT * 0.8;
  private Maze maze;
  private Point spriteCoordinates;

  public Pacman(Point initialPos, Direction initialDir, Maze maze){
    this.position = initialPos;
    this.direction = initialDir;
    this.maze = maze;
  }

  /**
   * if direction is {null} the direction is not changed.
   */
  public void setDirection(Direction direction) {
    if(direction != null){
      this.direction = direction;
    }
  }

  public void move(){
    double newX = position.x() * UNIT;
    double newY = position.y() * UNIT;
    newX += direction.getValue().x() * STEP_SIZE;
    newY += direction.getValue().y() * STEP_SIZE;
    newX /= UNIT;
    newY /= UNIT;
    if(canDoMove(newX, newY)){
      System.out.println("Moving");
      this.position.setLocation(newX, newY);
      checkOverflow();
    }else{
      System.out.println("Not Moving");
    }
  }

  private boolean canDoMove(double x, double y){
    return maze.intersectsWall(new Rectangle(x, y, extent, extent));
  }

  /**
   * check if Player has left the playing area and put them back
   */
  private void checkOverflow(){
    double x = this.spriteCoordinates.x() + extent/2;
    double y = this.spriteCoordinates.y() + extent/2;

    if(x < 0){
      this.position.setX(maze.getWidthInPixels());
    }else if (x > maze.getWidthInPixels()){
      this.position.setX(0);
    }

    if(y < 0){
      this.position.setY(maze.getHeightInPixels());
    }else if(y > maze.getHeightInPixels()){
      this.position.setY(0);
    }
  }

  public void draw(GraphicsContext ctx){
    this.spriteCoordinates = new Point(position.x() * UNIT + (UNIT/2), position.y() * UNIT + (UNIT/2));

    nomnom();
    ctx.setFill(this.COLOR);
    //ctx.fillArc(this.spriteCoordinates.x(), this.spriteCoordinates.y(), extent, extent, calculateMouthStartAngle(), 360-this.mouthAngle, ArcType.ROUND);
    ctx.fillRect(this.spriteCoordinates.x(), this.spriteCoordinates.y(), extent, extent);
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
