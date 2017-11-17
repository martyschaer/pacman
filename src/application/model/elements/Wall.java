package application.model.elements;

import static application.model.Utils.UNIT;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends GameElement{
  private Type type = Type.WALL;
  private Color color = new Color(0.13, 0.13, 0.87, 1);

  public Wall(Point position) {
    super(position);
  }

  @Override void draw(GraphicsContext ctx) {
    ctx.setFill(color);
    ctx.fillRect(this.getPosition().x * UNIT,
     this.getPosition().y * UNIT,
     UNIT,
     UNIT);
  }

  @Override Type getType() {
    return type;
  }
}
