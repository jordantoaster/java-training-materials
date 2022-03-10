package palindromes;

public class StringBuilderSolution {
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
        if (testForPalindrome(string)) {
            System.out.println("\"" + string + "\" is a Palindrome");
        } else {
            System.out.println("\"" + string + "\" is NOT a Palindrome");
        }
    }

    private static boolean testForPalindrome(String string) {
        String canonical = string.toLowerCase();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : canonical.toCharArray()) {
            if (Character.isLetter(c)) {
                sb1.append(c);
                sb2.insert(0, c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

}
