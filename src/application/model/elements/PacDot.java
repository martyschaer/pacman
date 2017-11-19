package application.model.elements;

import static application.model.Utils.UNIT;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PacDot extends GameElement{
  private Type type = Type.PAC_DOT;
  private Color color = new Color(1, 0.72, 0.59, 1);
  private static final int RADIUS = UNIT/8;
  private boolean eaten = false;

  public PacDot(Point position) {
    super(position);
  }

  @Override void draw(GraphicsContext ctx) {
    if(eaten){
      return;
    }
    ctx.setFill(Color.BLACK);
    ctx.fillRect(this.getPosition().x() * UNIT,
     this.getPosition().y() * UNIT,
     UNIT,
     UNIT);
    ctx.setFill(color);
    ctx.fillOval(this.getPosition().x() * UNIT + (UNIT/2 - RADIUS),
      this.getPosition().y() * UNIT + (UNIT/2 - RADIUS),
      RADIUS *2, RADIUS *2);
  }

  public void eat(){
    this.eaten = true;
  }

  public boolean isEaten(){
    return eaten;
  }

  @Override Type getType() {
    return type;
  }
}
