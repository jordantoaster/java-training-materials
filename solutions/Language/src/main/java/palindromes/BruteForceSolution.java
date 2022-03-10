package palindromes;

public class BruteForceSolution {
	private static final String data1 = "A man, a plan, a canal, Panama";
	private static final String data2 = "Gold is where you find it";
	private static final String data3 = "If I had a hi-fi";
	private static final String data4 = "Fortune favors the prepared mind";
	private static final String data5 = "Rats live on no evil star";
	private static final String data6 = "There is no abstract living";
	private static final String data7 = "Some men interpret nine memos";
	
	public static void main(String[] args) {
		test(data1);
		test(data2);
		test(data3);
		test(data4);
		test(data5);
		test(data6);
		test(data7);
	}
	private static void test(String string) {
		if(testForPalindrome(string)) {
			System.out.println("\"" + string + "\" is a Palindrome");
		} else {
			System.out.println("\"" + string + "\" is NOT a Palindrome");
		}
	}
	private static boolean testForPalindrome(String input) {
		String data = input.toLowerCase();
		
		int forward = 0;
		int back = data.length() - 1;
		
		while(forward < back) {
			while(isNotLetter(data.charAt(forward))) {
				forward++;
			}
			while(isNotLetter(data.charAt(back))) {
				back--;
			}
			if(data.charAt(forward) != data.charAt(back)) {
				return false;
			}
			forward++;
			back--;
		}
		return true;
	}
	private static boolean isNotLetter(char c) {
		return c < 'a' || c > 'z';
	}
}
