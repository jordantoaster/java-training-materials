package iteration;

import static java.lang.Thread.currentThread;
import static java.util.stream.DoubleStream.generate;
import static java.util.stream.IntStream.rangeClosed;

public class InternalIteration {
    public static void main(String[] args) {
        int max = 10;

        showIterationViaRanges(max);
        showIterationViaGenerate(max);
        showParallelIteration(max);
    }

    private static void showIterationViaRanges(int max) {
        System.out.println("Iteration with ranges");
        rangeClosed(1,max)
                .mapToObj(value -> "\tIteration: " + value)
                .forEach(System.out::println);
    }

    private static void showIterationViaGenerate(int max) {
        System.out.println("Iteration via generate");
        generate(Math::random)
                .mapToInt(value -> (int)(value * 100))
                .mapToObj(value -> "\tGenerated: " + value)
                .limit(max)
                .forEach(System.out::println);
    }

    private static void showParallelIteration(int max) {
        System.out.println("Parallel Iteration");
        rangeClosed(1,max)
                .parallel()
                .mapToObj(value -> "\tIteration: " + value)
                .map(str -> str + " on thread " + currentThread().getId())
                .forEach(System.out::println);
    }
}
