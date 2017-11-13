# A pacman game in Java using JavaFX written for a java course.

## Design
Below you'll find a rough draft of potential classes.

### GameElement
- Point coordinates;
- Image sprite;
- draw();

### abstract Movable
- Direction direction;
- move();

### Player extends GameElement implements Movable
- int lives;
- int score;

### Ghost extends GameElement implements Movable
- Strategy strategy;
- boolean hasDied;

### PacDots extends GameElement
- int points;

### PowerPellets extends PacDots

### Strategy
- Maze maze;
- getNextDirection();

### enum Direction
UP,LEFT,DOWN,RIGHT

### Stage
- int powerUpDuration;

### Maze
- isValidDirection();

### Game
- boolean playable;
- boolean hasWon;
- boolean powerUp;
- List<GameElement> elements;
- draw();

### Wall extends GameElement

### GhostWall extends Wall


### Renderer
- Canvas canvas;
- render(GameElement);
