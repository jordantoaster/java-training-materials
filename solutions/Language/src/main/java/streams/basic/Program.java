package streams.basic;

import java.text.DecimalFormat;
import java.util.stream.Stream;

import static java.lang.String.format;

public class Program {
    private static Stream<Stream<Double>> buildInput() {
        return Stream.generate(() -> Stream.generate(Math::random).limit(10)).limit(10);
    }

    public static void main(String[] args) {
        solutionOne();
        spacer();
        solutionTwo();
        spacer();
        solutionThree();
        spacer();
        solutionFour();
    }

    private static void spacer() {
        System.out.println("--------------------------");
    }

    private static void solutionOne() {
        Stream<Stream<Double>> input = buildInput();
        final DecimalFormat df = new DecimalFormat(".00");

        input.flatMap(x -> x)
                .filter(x -> x >= 0.5)
                .map(df::format)
                .forEach(System.out::println);
    }

    private static void solutionTwo() {
        Stream<Stream<Double>> input = buildInput();
        final DecimalFormat df = new DecimalFormat(".00");

        input.flatMap(x -> x.filter(y -> y >= 0.5))
                .map(df::format)
                .forEach(System.out::println);
    }

    private static void solutionThree() {
        Stream<Stream<Double>> input = buildInput();
        final DecimalFormat df = new DecimalFormat(".00");

        input.flatMap(x -> x.filter(y -> y >= 0.5)
                .map(df::format))
                .forEach(System.out::println);
    }

    private static void solutionFour() {
        Stream<Stream<Double>> input = buildInput();
        final DecimalFormat df = new DecimalFormat(".00");

        System.out.print(addThreadId("Main thread is "));

        String result = input.parallel()
                .flatMap(x -> x)
                .filter(x -> x >= 0.5)
                .map(df::format)
                .map(Program::addThreadId)
                .reduce((a, b) -> a + b)
                .orElse("");
        System.out.println(result);
    }

    private static String addThreadId(String s) {
        return format("%s (%d)\n", s, threadId());
    }

    private static long threadId() {
        return Thread.currentThread().getId();
    }
}
