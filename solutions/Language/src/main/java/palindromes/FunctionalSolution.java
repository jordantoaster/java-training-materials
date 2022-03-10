package palindromes;

import util.Pair;

import java.util.stream.Stream;

public class FunctionalSolution {
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

    private static void test(String input) {
        Stream<Integer> data = input.toLowerCase().chars().boxed();

        Pair<StringBuilder,StringBuilder> result = data
                .map(num -> (char) num.intValue())
                .filter(Character::isLetter)
                .reduce(new Pair<>(new StringBuilder(), new StringBuilder()),
                        (pair, str) -> {
                            pair.getFirst().append(str);
                            pair.getSecond().insert(0, str);
                            return pair;
                        },
                        (a, b) -> null);
        if (contentsAreEqual(result)) {
            System.out.printf("%s is a Palindrome\n", input);
        } else {
            System.out.printf("%s is NOT a Palindrome\n", input);
        }
    }

    private static boolean contentsAreEqual(Pair<StringBuilder, StringBuilder> pair) {
        String firstStr = pair.getFirst().toString();
        String secondStr = pair.getSecond().toString();
        return firstStr.equals(secondStr);
    }
}
