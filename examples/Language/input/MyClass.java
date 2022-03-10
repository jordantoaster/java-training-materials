
public class MyClass {
	public static void main(String[] args) {
		System.out.println("Hello from: " + MyClass.class.getName());
		System.out.println("Arguments are:");
		for(String arg : args) {
			System.out.printf("\t%s\n",arg);
		}
	}

}
