package com.drongox.marsrover;

import java.text.MessageFormat;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MarsRover {

  private int x;
  private int y;
  private Orientation orientation;


  public MarsRover(int x, int y, String orientation) {
    this.x = x;
    this.y = y;
    this.orientation = Orientation.of(orientation);
  }


  public String position() {
    return MessageFormat.format("{0}({1},{2})", orientation.id, x, y);
  }

  public void execute(String command) {
    orientation.forward(this);
  }

  enum Orientation {
    NORTH("N", marsRover -> marsRover.y++),
    //SOUTH("S"),
    EAST("E", marsRover -> marsRover.x++),
    WEST("W", marsRover -> marsRover.x--);

    private final String id;
    private Consumer<MarsRover> forwardExecutor;

    Orientation(String id,
        Consumer<MarsRover> forwardExecutor) {
      this.id = id;
      this.forwardExecutor = forwardExecutor;
    }

    private static Orientation of(String orientation) {
      return Stream.of(values())
          .filter(val -> val.id.equals(orientation))
          .findFirst()
          .orElseThrow();
    }

    public void forward(MarsRover marsRover) {
      forwardExecutor.accept(marsRover);
    }
  }
}
