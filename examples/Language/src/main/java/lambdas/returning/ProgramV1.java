package lambdas.returning;

import java.util.function.UnaryOperator;

public class ProgramV1 {
    private static UnaryOperator<String> buildWrapperV1(String tagName) {
        final String openingTag = String.format("<%s>", tagName);
        final String closingTag = String.format("</%s>", tagName);

        return s -> openingTag + s + closingTag;
    }

    public static void main(String[] args) {
        UnaryOperator<String> wrapInH1 = buildWrapperV1("h1");
        UnaryOperator<String> wrapInH2 = buildWrapperV1("h2");
        UnaryOperator<String> wrapInEm = buildWrapperV1("em");

        System.out.println(wrapInH1.apply("foo"));
        System.out.println(wrapInH2.apply("bar"));
        System.out.println(wrapInEm.apply("zed"));
    }
}
