package application.model.elements;

import static application.model.Utils.UNIT;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PacDot extends GameElement{
  private Type type = Type.PAC_DOT;
  private Color color = new Color(1, 0.72, 0.59, 1);
  private static final int RADIUS = UNIT/8;

  public PacDot(Point position) {
    super(position);
  }

  @Override void draw(GraphicsContext ctx) {
    ctx.setFill(Color.BLACK);
    ctx.fillRect(this.getPosition().x * UNIT,
     this.getPosition().y * UNIT,
     UNIT,
     UNIT);
    ctx.setFill(color);
    ctx.fillOval(this.getPosition().x * UNIT + (UNIT/2 - RADIUS),
      this.getPosition().y * UNIT + (UNIT/2 - RADIUS),
      RADIUS *2, RADIUS *2);
  }

  @Override Type getType() {
    return null;
  }
}
