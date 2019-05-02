package com.drongox.marsrover;

import java.text.MessageFormat;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MarsRover {

  public static final int MAX_SIZE = 5;
  public static final int MIN_SIZE = 0;
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
    if(orientation==Orientation.NORTH){
      if(y>=5){
        return;
      }
    }
    else if(orientation==Orientation.SOUTH){
      if(y==0){
        return;
      }
    }
    orientation.forward(this);
  }

  enum Orientation {
    NORTH("N", rover -> rover.y++, rover -> rover.y == MAX_SIZE),
    SOUTH("S", rover -> rover.y--, rover -> rover.y == MIN_SIZE),
    EAST("E", rover -> rover.x++, rover -> rover.x==MAX_SIZE),
    WEST("W", rover -> rover.x--, rover -> rover.x==MIN_SIZE);

    private final String id;
    private Consumer<MarsRover> forwardExecutor;
    private Predicate<MarsRover> forwardBorderChecker;


    Orientation(String id,
                Consumer<MarsRover> forwardExecutor,
                Predicate<MarsRover> forwardBorderChecker) {
      this.id = id;
      this.forwardExecutor = forwardExecutor;
      this.forwardBorderChecker = forwardBorderChecker;
    }

    private static Orientation of(String orientation) {
      return Stream.of(values())
          .filter(val -> val.id.equals(orientation))
          .findFirst()
          .orElseThrow();
    }

    public void forward(MarsRover marsRover)
    {
      if(forwardBorderChecker.test(marsRover)){
        return;
      }

      forwardExecutor.accept(marsRover);
    }
    
  }
}
