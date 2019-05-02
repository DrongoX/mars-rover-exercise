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
      | 1 | 2 | S           | S(1,1) |
      | 1 | 5 | N           | N(1,5) |
      | 1 | 0 | S           | S(1,0) |
      | 0 | 2 | W           | W(0,2) |
      | 5 | 3 | E           | E(5,3) |

  Scenario Outline:
    Given a Mars Rover situated at <x>, <y> and oriented <orientation>
    When Mars Rover receives a command B
    And Mars Rover is asked to report his position
    Then the output is <output>
    Examples:
      | x | y | orientation | output |
      | 1 | 2 | W           | W(2,2) |
      | 1 | 2 | E           | E(0,2) |
      | 1 | 2 | N           | N(1,1) |
