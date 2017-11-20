package application.model.elements;

import static application.model.Utils.UNIT;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Maze {
  private final int mazeTemplate[][] = {
   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
   {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
   {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
   {1,5,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,5,1},
   {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
   {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
   {1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1},
   {1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1},
   {1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1},
   {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,1,1,1,0,0,1,1,1,0,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,1,0,0,0,0,0,0,1,0,1,1,2,1,1,1,1,1,1},
   {0,0,0,0,0,0,2,0,0,0,1,0,0,0,0,0,0,1,0,0,0,2,0,0,0,0,0,0},
   {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},
   {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},
   {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},
   {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
   {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},
   {1,5,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,5,1},
   {1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1},
   {1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1},
   {1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1},
   {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
   {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},
   {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
  };
  private final List<List<GameElement>> maze = new ArrayList<>(mazeTemplate.length);
  private static int width = 0;
  private static int height = 0;

  public Maze(){
    height = mazeTemplate.length;
    width = mazeTemplate[0].length;

    for(int y = 0; y < mazeTemplate.length; y++) {
      int[] rowTemplate = mazeTemplate[y];
      List<GameElement> row = new ArrayList<>(rowTemplate.length);
      for (int x = 0; x < rowTemplate.length; x++) {
        GameElement.Builder builder = new GameElement.Builder();
        builder.setPosition(new Point(x, y));
        builder.setType(Type.get(mazeTemplate[y][x]));
        row.add(builder.build());
      }
      maze.add(row);
    }
  }

  public void draw(GraphicsContext ctx){
    for(List<GameElement> row : this.maze){
      for(GameElement element : row){
        element.draw(ctx);
      }
    }
  }

  public boolean intersectsElement(Rectangle rect, Class clazz){
    for (List<GameElement> row : maze){
      for (GameElement el : row){
        double cordX = el.getPosition().x();
        double cordY = el.getPosition().y();
        if(clazz.isInstance(el) && rect.intersects(cordX, cordY, 1, 1)){
          updateElement(el);
          return true;
        }
      }
    }
    return false;
  }

  private void updateElement(GameElement genericElement){
    if(genericElement instanceof PacDot){
      PacDot element = (PacDot)genericElement;
      element.eat();
    }else if(genericElement instanceof PowerPellet){
      PowerPellet element = (PowerPellet)genericElement;
      element.eat();
    }
  }

  public boolean elementIsEaten(double x, double y){
    x++;y++;
    GameElement generic = maze.get((int)y).get((int)x);
    if(generic.getType() == Type.PAC_DOT){
      PacDot dot = (PacDot)generic;
      return dot.isEaten();
    }else if(generic.getType() == Type.POWER_PELLET){
      PowerPellet pellet = (PowerPellet)generic;
      return pellet.isEaten();
    }
    return false;
  }

  public int getWidthInPixels() {
    return width * UNIT;
  }

  public int getHeightInPixels() {
    return height * UNIT;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
