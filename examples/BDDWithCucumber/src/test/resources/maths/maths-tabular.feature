Feature: Scenarios using tables

  Scenario: The object supports arithmetic
    Given a math object created with 12 and 34
    Then these are the totals produced
      | addition       | 46  |
      | subtraction    | -22 |
      | multiplication | 408 |

  Scenario: The object does arithmetic
    Given a math object created with 12 and 34
    Then these are the results produced
      |  addition  | subtraction  | multiplication |
      |     46     |     -22      |      408       |
