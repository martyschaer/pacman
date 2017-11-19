package application.model;

import javafx.scene.input.KeyCode;

public class Utils {
  public static int UNIT = 30;

  public static Direction mapKeyPressToDirection(KeyCode keyCode){
    switch (keyCode){
      case UP:    return Direction.UP;
      case LEFT:  return Direction.LEFT;
      case DOWN:  return Direction.DOWN;
      case RIGHT: return Direction.RIGHT;
      default:    return null;
    }
  }
}
