package palindromes;

public class ReplaceBasedSolution {
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
        canonical = canonical.replace(" ", "");
        canonical = canonical.replace(",", "");
        canonical = canonical.replace("-", "");

        char[] content = canonical.toCharArray();
        String reversed = "";
        for (int i = content.length - 1; i >= 0; i--) {
            reversed = reversed + content[i];
        }
        return canonical.equals(reversed);
    }
}
