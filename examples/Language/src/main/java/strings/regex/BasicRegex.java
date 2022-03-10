package strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicRegex {
    public static void main(String[] args) {
        String data = "ABCdef#GHIjkl#MNOpqr#STUvwx#YZA";

        //Three uppercase letters
        printMatches(data, "[A-Z]{3}");

        //Three uppercase letters followed by a single lowercase letter
        printMatches(data, "[A-Z]{3}[a-z]");

        //Three uppercase letters followed by two lowercase letters
        printMatches(data, "[A-Z]{3}[a-z]{2}");

        //An uppercase letters followed by one or more
        // letters and ending in a hash
        printMatches(data, "[A-Z][A-Za-z]+#");

        //An uppercase letters followed by one or more
        // characters and ending in a hash
        //Note that the expression is 'greedy'
        printMatches(data, "[A-Z].+#");

        //An uppercase letters followed by one or more
        // characters and ending in a hash
        //Note that the expression is 'non-greedy'
        printMatches(data, "[A-Z].+?#");

        //Any sequence of characters that doesnt contain a vowel
        printMatches(data, "[^AEIOUaeiou]+");

        //The start of the string followed by six characters
        printMatches(data, "^.{6}");

        //The six characters before the end of the string
        printMatches(data, ".{6}$");

        //Sequences of two word characters
        printMatches(data, "\\w{5}");

        //Sequences of three word characters, optionally
        // followed by a hash
        printMatches(data, "\\w{3}#?");

        //Two word characters before a hash OR
        // three uppercase letters
        printMatches(data, "\\w{2}#|[A-Z]{3}");
    }

    private static void printMatches(String data, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);
        System.out.println("Matches for " + regex + " are:");
        while (m.find()) {
            System.out.println("\t" + m.group());
        }
    }
}
