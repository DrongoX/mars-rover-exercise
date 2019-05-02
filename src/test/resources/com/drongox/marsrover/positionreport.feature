Feature: Mars Rover should be able to report his current position

  Scenario Outline: Mars Rover is correctly reporting his current position
    Given a Mars Rover situated at <x>, <y> and oriented <orientation>
    When Mars Rover is asked to report his position
    Then the output is <output>
    Examples:
      | x | y | orientation | output |
      | 1 | 1 | W           | W(1,1) |
      | 2 | 2 | E           | E(2,2) |
