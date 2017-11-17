package application;

import java.awt.Point;

import application.model.Direction;
import application.model.Pacman;
import application.model.elements.Maze;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    Maze maze = new Maze();
    int mazeWidth = maze.getWidth();
    int mazeHeight = maze.getHeight();
    final Canvas canvas = new Canvas(mazeWidth, mazeHeight);
    Parent root = new BorderPane(canvas);
    primaryStage.setTitle("PacMan");
    Scene scene = new Scene(root, mazeWidth, mazeHeight, Color.BLACK);
    primaryStage.setScene(scene);
    primaryStage.show();

    Pacman pacman = new Pacman(new Point(1, 1), Direction.RIGHT);

    GraphicsContext ctx = canvas.getGraphicsContext2D();

    AnimationTimer timer = new AnimationTimer() {
      long lastUpdate = 0;
      @Override public void handle(long now) {
        if(now - lastUpdate >= 16_000_000){
          resetCanvas(ctx, canvas.getWidth(), canvas.getHeight());
          maze.draw(ctx);
          pacman.draw(ctx);
          lastUpdate = now;
        }
      }
    };

    timer.start();
  }

  private void resetCanvas(GraphicsContext ctx, double x, double y){
    ctx.clearRect(0, 0, x, y);
  }

  private void handleInput(KeyCode key){

  }

  public static void main(String[] args) {
    launch(args);
  }
}
