package annotations.xunit;

import annotations.xunit.tool.*;

@TestCase
public class MyTestOne {
	
	public void op1() {
		System.out.println("MyTestOne.op1 called");
	}
	@Test
	public void op2() {
		System.out.println("MyTestOne.op2 called");
	}
	@Test(order = 2)
	public void op3() {
		System.out.println("MyTestOne.op3 called");
	}
	@Test(order = 1, ignore = true)
	public void op4() {
		System.out.println("MyTestOne.op4 called");
	}
}
