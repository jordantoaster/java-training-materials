Feature: Using outline scenarios

  Scenario Outline: Rules for cells
    Given a new cell which is <initialState>
    And <number> neighbours are ALIVE
    Then the next state will be <nextState>
    Examples:
      | initialState | number | nextState |
      |    ALIVE     |   1    |    DEAD   |
      |    ALIVE     |   2    |    ALIVE  |
      |    ALIVE     |   3    |    ALIVE  |
      |    ALIVE     |   4    |    DEAD   |
      |    ALIVE     |   5    |    DEAD   |
      |    ALIVE     |   6    |    DEAD   |
      |    ALIVE     |   7    |    DEAD   |
      |    ALIVE     |   8    |    DEAD   |
      |    DEAD      |   1    |    DEAD   |
      |    DEAD      |   2    |    DEAD   |
      |    DEAD      |   3    |    ALIVE  |
      |    DEAD      |   4    |    DEAD   |
      |    DEAD      |   5    |    DEAD   |
      |    DEAD      |   6    |    DEAD   |
      |    DEAD      |   7    |    DEAD   |
      |    DEAD      |   8    |    DEAD   |


