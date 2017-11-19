package application;

import static application.model.Utils.mapKeyPressToDirection;

import application.model.Direction;
import application.model.elements.Maze;
import application.model.elements.Pacman;
import application.model.elements.Point;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
  public static int POINTS = 200;
  public static int POWER_POINTS = 500;
  public static int GHOST_POINTS = 2500;
  private int points = 0;

  @Override
  public void start(Stage primaryStage) throws Exception{
    Maze maze = new Maze();
    int mazeWidth = maze.getWidthInPixels();
    int mazeHeight = maze.getHeightInPixels();
    final Canvas canvas = new Canvas(mazeWidth, mazeHeight);
    Parent root = new BorderPane(canvas);
    primaryStage.setTitle("PacMan");
    Scene scene = new Scene(root, mazeWidth, mazeHeight, Color.BLACK);
    primaryStage.setScene(scene);
    primaryStage.show();

    Pacman pacman = new Pacman(new Point(13, 13), Direction.RIGHT, maze);

    GraphicsContext ctx = canvas.getGraphicsContext2D();

    scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> handleInput(keyEvent.getCode(), pacman));

    AnimationTimer timer = new AnimationTimer() {
      long lastUpdate = 0;
      @Override public void handle(long now) {
        if(now - lastUpdate >= 16_000_000){
          resetCanvas(ctx, canvas.getWidth(), canvas.getHeight());
          maze.draw(ctx);
          points += pacman.move();
          pacman.draw(ctx);
          drawScore(ctx);
          lastUpdate = now;
        }
      }
    };

    timer.start();
  }

  private void drawScore(GraphicsContext ctx){
    ctx.setFill(Color.WHITE);
    ctx.setTextAlign(TextAlignment.LEFT);
    ctx.setTextBaseline(VPos.TOP);
    ctx.setFont(Font.font("Source Code Pro", 18));
    ctx.fillText(String.valueOf(points),10,10);
  }

  private void resetCanvas(GraphicsContext ctx, double x, double y){
    ctx.clearRect(0, 0, x, y);
  }

  private void handleInput(KeyCode key, Pacman pacman){
    pacman.setDirection(mapKeyPressToDirection(key));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
