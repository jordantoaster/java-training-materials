Feature: Using outline scenarios

  Scenario Outline: performing arithmetic
    Given a math object created with <first> and <second>
    Then addition produces <addition>
    And subtraction produces <subtraction>
    And multiplication produces <multiplication>

    Examples:
      | first | second | addition | subtraction | multiplication |
      |   10  |   20   |    30    |     -10     |       200      |
      |   11  |   30   |    41    |     -19     |       330      |
      |   12  |   40   |    52    |     -28     |       480      |
      |   13  |   50   |    63    |     -37     |       650      |