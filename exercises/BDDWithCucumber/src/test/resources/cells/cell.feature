Feature: Working with the Game of Life Cell

  Scenario: The cell is dead by default
    Given a new cell
    Then the state of the cell is DEAD

  Scenario: Cells can become alive
    Given a new cell
    When we make it ALIVE
    Then the state of the cell is ALIVE
