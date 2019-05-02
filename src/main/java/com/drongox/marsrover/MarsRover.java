package com.drongox.marsrover;

import java.text.MessageFormat;

public class MarsRover
{
  private final int x;
  private final int y;
  private final String orientation;


  public MarsRover(int x, int y, String orientation)
  {

    this.x = x;
    this.y = y;
    this.orientation = orientation;
  }


  public String position()
  {
    return MessageFormat.format("{0}({1},{2})", orientation, x, y);
  }
}
