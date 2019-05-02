package com.drongox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class MarsRoverStepDef
{
  private MarsRover marsRover;
  private String outputPosition;


  @Given("^a Mars Rover situated at (\\d+), (\\d+) and oriented ([W|E|S|N])$")
  public void aMarsRoverSituatedAtAndOriented(int x, int y, String orientation)
  {
    marsRover = new MarsRover(x, y, orientation);
  }


  @When("Mars Rover is asked to report his position")
  public void marsRoverIsAskedToReportHisPosition()
  {
    outputPosition = marsRover.position();
  }


  @Then("^the output is (.*)$")
  public void theOutputIs(String output)
  {
    assertThat(outputPosition).isEqualTo(output);
  }

  @When("^Mars Rover receives a command ([F|B])$")
  public void marsRoverReceivesACommand(String command) {
    marsRover.execute(command);
  }
}
