package equality;

/**
 * @author Garth Gilmour
 *
 */
public class StringEquality {
	public static void main(String[] args) {
		String s1 = new String("Fred");
		String s2 = new String("Fred");

		System.out.println("\nComparing references to 2 String objects");
		testStrings(s1,s2);

		s1 = s2;

		System.out.println("\nComparing 2 references to 1 String object");
		testStrings(s1,s2);

		String s3 = "Fred";

		System.out.println("\nComparing String object reference to String literal reference");
		testStrings(s2,s3);

		String s4 = "Fred";

		System.out.println("\nComparing 2 String literal references");
		testStrings(s3,s4);
	}
	private static void testStrings(String p1, String p2) {
		if(p1 == p2) {
			System.out.println("p1 ref equals p2 ref");
		}
		else {
			System.out.println("p1 ref does not equal p2 ref");
		}
		if(p1.equals(p2)) {
			System.out.println("p1 content equals p2 content");
		}
		else {
			System.out.println("p1 content does not equal p2 content");
		}
	}
}
