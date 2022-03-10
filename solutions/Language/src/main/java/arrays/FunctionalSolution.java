package arrays;

import static java.util.Arrays.stream;

public class FunctionalSolution {

    /**
     * This is the key for rendering the image:
     * <p>
     * space = 0
     * ( = 1
     * ) = 2
     * _ = 3
     * | = 4
     * * = 5
     * - = 6
     * / = 7
     * \ = 8
     *
     * @ = 9
     * o = 10
     */

    @SuppressWarnings("unused")
    private static int[][] compuCow = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 7, 8, 3, 4, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 6, 6, 6, 9, 0, 0, 0, 0, 4, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0},
            {0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 4, 0, 0, 0, 6, 6, 6, 6, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 4, 0, 0, 4, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 8, 4, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0}
    };

    public static void main(String[] args) {
        simpleVersion();
        System.out.println("\n-------------------\n");
        threadSafeVersion();
    }

    private static void simpleVersion() {
        stream(compuCow)
                .parallel() //deliberate heisenbug
                .forEach(subArray -> {
                        stream(subArray)
                                .mapToObj(FunctionalSolution::mapInt)
                                .forEach(System.out::print);
                        System.out.println();
                });
    }

    private static void threadSafeVersion() {
        stream(compuCow)
                .parallel()
                .map(subArray ->
                        stream(subArray)
                                .mapToObj(FunctionalSolution::mapInt)
                                .reduce((a, b) -> a + b)
                                .map(a -> a + " " + Thread.currentThread().getId())
                                .map(a -> a + "\n")
                                .orElse(""))
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }

    private static String mapInt(int input) {
        final String [] values = { " ", "(", ")", "_", "|", "*", "-" , "/", "\\", "@", "o"};
        if(input < values.length) {
            return values[input];
        }
        return "?";
    }
}
