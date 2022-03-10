Feature: Working with the Data Access Object

  Scenario: The DAO is empty by default
    Given a new DAO
    Then there are 0 employees present

  Scenario: Employees can be added to the DAO
    Given a new DAO
    When we add Dave of age 27 earning 30000
    And we add Jane of age 28 earning 40000
    And we add Fred of age 29 earning 50000
    Then there are 3 employees present

  Scenario: Employees can be found via the DAO
    Given a new DAO
    When we add Dave of age 27 earning 30000
    And we add Jane of age 28 earning 40000
    And we add Fred of age 29 earning 50000
    Then 123 is Dave of age 27 earning 30000
    And 124 is Jane of age 28 earning 40000
    And 125 is Fred of age 29 earning 50000

  Scenario: Employees can be removed
    Given a new DAO
    When we add Dave of age 27 earning 30000
    And we add Jane of age 28 earning 40000
    And we add Fred of age 29 earning 50000
    And we remove employee 124
    Then there are 2 employees present
    And 123 is Dave of age 27 earning 30000
    And 125 is Fred of age 29 earning 50000
    And 124 cannot be found

  Scenario: Data is persisted across DAO instances
    Given a new DAO
    When we add Dave of age 27 earning 30000
    And we add Jane of age 28 earning 40000
    And we add Fred of age 29 earning 50000
    And we recreate the DAO
    Then there are 3 employees present
    And 123 is Dave of age 27 earning 30000
    And 124 is Jane of age 28 earning 40000
    And 125 is Fred of age 29 earning 50000

