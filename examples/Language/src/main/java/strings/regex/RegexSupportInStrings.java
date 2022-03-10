package strings.regex;

public class RegexSupportInStrings {

    public static void main(String[] args) {
        String data = "ABCdef#GHIjkl#MNOpqr#STUvwx#YZA";

        //The String class has a built in function for pattern matching
        if (data.matches(".*[A-Z]{3}.*")) {
            System.out.println("At least one sequence of three uppercase letters in string...\n");
        }
        if (!data.matches(".*[A-Z]{4}.*")) {
            System.out.println("No sequence of four uppercase letters in string...\n");
        }

        //The String class has regex based functions to replace StringTokenizer
        String[] tokens = data.split("[a-z]#[A-Z]");
        System.out.println("Tokens from string are:");
        for (String token : tokens) {
            System.out.println("\t" + token);
        }

        //The String class has methods for substituting characters
        String result = data.replaceAll("[a-z]#[A-Z]", "-->");
        System.out.println("String after replacements is: " + result);
    }

}
