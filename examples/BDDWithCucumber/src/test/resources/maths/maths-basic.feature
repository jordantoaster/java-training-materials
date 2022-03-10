Feature: Simple examples of scenarios

  Scenario: The object can add values
    Given a math object created with 12 and 34
    Then addition produces 46

  Scenario: The object can subtract values
    Given a math object created with 12 and 16
    Then subtraction produces -4

  Scenario: The object can multiply values
    Given a math object created with 12 and 4
    Then multiplication produces 48