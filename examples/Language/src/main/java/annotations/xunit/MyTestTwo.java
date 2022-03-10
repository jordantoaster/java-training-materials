package annotations.xunit;

import annotations.xunit.tool.*;

@TestCase("Second Test Class")
public class MyTestTwo {
	@Test(order = 1, ignore = true)
	public void op1() {
		System.out.println("MyTestTwo.op1 called");
	}
	@Test(ignore = true)
	public void op2() {
		System.out.println("MyTestTwo.op2 called");
	}
	@Test
	public void op3() {
		System.out.println("MyTestTwo.op3 called");
	}
	public void op4() {
		System.out.println("MyTestTwo.op4 called");
	}
}
