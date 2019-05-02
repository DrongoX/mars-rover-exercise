package com.drongox.marsrover;

import java.util.function.Consumer;
import java.util.stream.Stream;

public enum Command
{
  FORWARD("F", rover -> rover.orientation.forward(rover)),
  BACKWARD("B", rover -> rover.orientation.backward(rover));

  private String id;
  private Consumer<MarsRover> commandExecutor;


  Command(String id, Consumer<MarsRover> commandExecutor) {this.id = id;
    this.commandExecutor = commandExecutor;
  }


  static Command of(String command) {
    return Stream.of(values())
          .filter(c -> c.id.equals(command))
          .findFirst()
          .orElseThrow();
  }


  public void execute(MarsRover marsRover)
  {
    commandExecutor.accept(marsRover);
  }
}
