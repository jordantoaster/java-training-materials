Feature: Removing items from the list

	Scenario: The only item can be removed
		Given an empty list
		When we add in abc
		And we remove abc
		Then the list is empty

	Scenario: Multiple items can be removed
		Given a list holding abc, def, ghi, jkl, mno, pqr
		Then the content is abc, def, ghi, jkl, mno, pqr
		When we remove abc
		Then the adjusted content is:
		|  0  | def |
		|  1  | ghi |
		|  2  | jkl |
		|  3  | mno |
		|  4  | pqr |
		When we remove pqr
		Then the adjusted content is:
		|  0  | def |
		|  1  | ghi |
		|  2  | jkl |
		|  3  | mno |
		When we remove jkl
		Then the adjusted content is:
		|  0  | def |
		|  1  | ghi |
		|  2  | mno |
