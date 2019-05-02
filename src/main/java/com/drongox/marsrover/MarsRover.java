package com.drongox.marsrover;

import java.text.MessageFormat;

public class MarsRover
{

  static final int MAX_SIZE = 5;
  static final int MIN_SIZE = 0;

  int x;
  int y;
  Orientation orientation;


  public MarsRover(int x, int y, String orientation)
  {
    this.x = x;
    this.y = y;
    this.orientation = Orientation.of(orientation);
  }


  public String position()
  {
    return MessageFormat.format("{0}({1},{2})", orientation.id, x, y);
  }


  public void execute(String command)
  {
    Command cmd = Command.of(command);
    cmd.execute(this);
  }

}
