package application.model.elements;

import java.util.NoSuchElementException;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameElement {
  private Point position;

  public GameElement(Point position){
    this.position = position;
  }

  abstract void draw(GraphicsContext ctx);

  Point getPosition(){
    return position;
  }

  abstract Type getType();

  static class Builder{
    private Point position;
    private Type type;

    public GameElement build(){
      switch (type){
        case FLOOR:           return new Floor(position);
        case WALL:            return new Wall(position);
        case PAC_DOT:         return new PacDot(position);
        case POWER_PELLET:  return new PowerPellet(position);
        default: throw new NoSuchElementException("no such game element");
      }
    }

    public void setPosition(Point position){
      this.position = position;
    }

    public void setType(Type type){
      this.type = type;
    }

  }
}
