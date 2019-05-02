package com.drongox.marsrover;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

enum Orientation
{
  NORTH("N",
        rover -> rover.y++,
        rover -> rover.y == MarsRover.MAX_SIZE,
        rover -> rover.y--),
  SOUTH("S",
        rover -> rover.y--,
        rover -> rover.y == MarsRover.MIN_SIZE,
        rover -> rover.y++),
  EAST("E",
       rover -> rover.x++,
       rover -> rover.x == MarsRover.MAX_SIZE,
       rover -> rover.x--),
  WEST("W",
       rover -> rover.x--,
       rover -> rover.x == MarsRover.MIN_SIZE,
       rover -> rover.x++);

  final String id;
  private Consumer<MarsRover> forwardExecutor;
  private Predicate<MarsRover> forwardBorderChecker;
  private Consumer<MarsRover> backwardExecutor;


  Orientation(String id,
              Consumer<MarsRover> forwardExecutor,
              Predicate<MarsRover> forwardBorderChecker,
              Consumer<MarsRover> backwardExecutor)
  {
    this.id = id;
    this.forwardExecutor = forwardExecutor;
    this.forwardBorderChecker = forwardBorderChecker;
    this.backwardExecutor = backwardExecutor;
  }


  static Orientation of(String orientation)
  {
    return Stream.of(values())
                 .filter(val -> val.id.equals(orientation))
                 .findFirst()
                 .orElseThrow();
  }


  public void forward(MarsRover marsRover)
  {
    if (forwardBorderChecker.test(marsRover)) {
      return;
    }

    forwardExecutor.accept(marsRover);
  }


  public void backward(MarsRover marsRover)
  {
    backwardExecutor.accept(marsRover);
  }
}
