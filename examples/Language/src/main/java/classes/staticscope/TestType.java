package classes.staticscope;

public class TestType {
	public TestType() {
		numCreated++;
		numInMemory++;
	}
	protected void finalize() throws Throwable {
		numInMemory--;
	}
	public static int getNumCreated() {
		return numCreated;
	}
	public static int getNumInMemory() {
		return numInMemory;
	}
	private static int numCreated;
	private static int numInMemory;
}
