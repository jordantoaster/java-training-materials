package tricky.reductions;

import java.util.stream.IntStream;

class Program {
    public static void main(String[] args) {
        sumViaReduce(data());
        productViaReduce(data());
        countViaReduce(data());
        averageViaReduce(data());
        lastViaReduce(data());
        penultimateViaReduce(data());
        reverseViaReduce(data());
    }

    private static IntStream data() {
        return IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 101, 10003);
    }

    private static void sumViaReduce(IntStream data) {
        int result = 0;
        System.out.println("Sum of elements is " + result);
    }

    private static void productViaReduce(IntStream data) {
        int result = 0;
        System.out.println("Product of elements is " + result);
    }

    private static void countViaReduce(IntStream data) {
        int result = 0;
        System.out.println("Count of elements is " + result);
    }
    private static void averageViaReduce(IntStream data) {
        double result = 0;
        System.out.println("Average of elements is " + result);
    }

    private static void lastViaReduce(IntStream data) {
        int result = 0;
        System.out.println("The last elements is " + result);
    }

    private static void penultimateViaReduce(IntStream data) {
        int result = 0;
        System.out.println("The penultimate elements is " + result);
    }

    private static void reverseViaReduce(IntStream data) {
        System.out.println("The list in reverse is:");
    }
}
