package lambdas.using;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.getNumericValue;

public class AvoidingBlockLambdas {
    public static void main(String[] args) {
        List<String> isbnExamples = Arrays.asList("1449457959",
                "3657481935",
                "0615314465",
                "9182373845",
                "1848549571",
                "4637289123",
                "1491928050");

        poorDesign(isbnExamples.stream());
        System.out.println("-----------------");
        goodDesign(isbnExamples.stream());
    }

    private static void poorDesign(Stream<String> stream) {
        System.out.println("Valid ISBN's are:");
        stream.filter(isbn -> {
            int total = 0;
            for (int x = 10, y = 0; x > 0; x--, y++) {
                total += convertCharToDigit(isbn, y) * x;
            }
            return total % 11 == 0;
        }).forEach(System.out::println);
    }

    private static void goodDesign(Stream<String> stream) {
        System.out.println("Valid ISBN's are:");
        stream.filter(AvoidingBlockLambdas::validateTenDigitIsbn)
                .forEach(System.out::println);
    }

    private static int convertCharToDigit(String input, int index) {
        return getNumericValue(input.charAt(index));
    }

    private static boolean validateTenDigitIsbn(String isbn) {
        int total = 0;
        for (int x = 10, y = 0; x > 0; x--, y++) {
            total += convertCharToDigit(isbn, y) * x;
        }
        return total % 11 == 0;
    }
}
