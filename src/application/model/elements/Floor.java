package application.model.elements;

import static application.model.Utils.UNIT;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Floor extends GameElement{
  private Type type = Type.FLOOR;
  private Color color = Color.BLACK;

  public Floor(Point position) {
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
