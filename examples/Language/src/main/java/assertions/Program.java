package assertions;


public class Program {

	public static void main(String[] args) {
		double value = Math.random();
		assert value > 0.5 : "Value " + value + " too small";
		assert value < 0.5 : "Value " + value + " too big";
		System.out.println("No assertions triggered");
	}
}
