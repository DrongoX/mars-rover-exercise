Feature: Mars Rover should be able to move forward or backward

  Scenario Outline:
    Given a Mars Rover situated at <x>, <y> and oriented <orientation>
    When Mars Rover receives a command F
    And Mars Rover is asked to report his position
    Then the output is <output>
    Examples:
      | x | y | orientation | output |
      | 1 | 2 | W           | W(0,2) |
      | 1 | 2 | E           | E(2,2) |
      | 1 | 2 | N           | N(1,3) |
