Feature: Working with the Game of Life Cell

  Scenario: The cell is dead by default
    Given a new cell
    Then the state of the cell is DEAD

  Scenario: Cells can become alive
    Given a new cell
    When we make it ALIVE
    Then the state of the cell is ALIVE

  Scenario: Cells cannot have more than eight neighbours
    Given a new cell with neighbours
    When we add a new neighbour
    Then an exception is thrown

  Scenario: A live cell with three live neighbours stays alive
    Given a new cell
    When we make it ALIVE
    And 3 neighbours are ALIVE
    Then the next state will be ALIVE

  Scenario: A live cell with two live neighbours stays alive
    Given a new cell
    When we make it ALIVE
    And 2 neighbours are ALIVE
    Then the next state will be ALIVE

  Scenario: A dead cell with three live neighbours becomes alive
    Given a new cell
    When 3 neighbours are ALIVE
    Then the next state will be ALIVE

  Scenario: A live cell with more than three live neighbours dies
    Given a new cell
    When we make it ALIVE
    And 4 neighbours are ALIVE
    Then the next state will be DEAD

  Scenario: A live cell with less than two live neighbours dies
    Given a new cell
    When we make it ALIVE
    And 1 neighbours are ALIVE
    Then the next state will be DEAD