Feature: Working with empty lists

	Scenario: A new list is empty
		Given a new list
		Then the size is 0
		
	Scenario: An empty list is empty
		Given a list of size 0
		Then the list is empty
