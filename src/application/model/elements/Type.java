package application.model.elements;

import java.util.NoSuchElementException;

public enum Type {
  FLOOR(0),
  WALL(1),
  PAC_DOT(2),
  GHOST(10),
  PACMAN(100),
  POWER_PELLET(5);
  private int value;

  Type(int value){
    this.value = value;
  }

  public static Type get(int v){
    for(Type t : Type.values()){
      if(t.value == v){
        return t;
      }
    }
    throw new NoSuchElementException("no such type exists");
  }
}
