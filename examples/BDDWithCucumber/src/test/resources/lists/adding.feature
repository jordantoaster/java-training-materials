Feature: Adding items to the list

	Scenario: A single item can be added
		Given an empty list
		When we add in abc
		Then the content is abc

	Scenario: Multiple items can be added
		Given an empty list
		When we add in abc
		Then the content is abc
		When we add in def
		Then the content is abc, def
		When we add in ghi
		Then the content is abc, def, ghi
		When we add all of jkl, mno, pqr
		Then the content is abc, def, ghi, jkl, mno, pqr
