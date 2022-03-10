package tricky.reductions;

import util.Pair;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Program {
    public static void main(String[] args) {
        sumViaReduceV1(data());
        sumViaReduceV2(data());
        sumViaCollect(data());
        productViaReduce(data());
        countViaReduce(data());
        countViaCollect(data());
        averageViaReduce(data());
        averageViaReduceParallel(data());
        averageViaCollect(data());
        lastViaReduce(data());
        penultimateViaReduce(data());
        reverseViaReduce(data());
    }

    private static Stream<Integer> data() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private static void sumViaReduceV1(Stream<Integer> data) {
        int result = data.reduce((a, b) -> a + b).orElse(0);
        System.out.println("Sum of elements is " + result);
    }

    private static void sumViaReduceV2(Stream<Integer> data) {
        int result = data.reduce(Integer::sum).orElse(0);
        System.out.println("Sum of elements is " + result);
    }

    private static void sumViaCollect(Stream<Integer> data) {
        long result = data.collect(summarizingInt(x -> x)).getSum();
        System.out.println("Sum of elements via collect is " + result);
    }

    private static void productViaReduce(Stream<Integer> data) {
        int result = data.reduce((a, b) -> a * b).orElse(0);
        System.out.println("Product of elements is " + result);
    }

    private static void countViaReduce(Stream<Integer> data) {
        int result = data.reduce(0, (sum, item) -> sum + 1);
        System.out.println("Count of elements is " + result);
    }

    private static void countViaCollect(Stream<Integer> data) {
        long result = data.collect(counting());
        System.out.println("Count of elements via collect is " + result);
    }

    private static void averageViaReduce(Stream<Integer> data) {
        BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> operator = (pair, item) -> {
            int newTotal = pair.getFirst() + item;
            int newCount = pair.getSecond() + 1;
            return new Pair<>(newTotal, newCount);
        };

        BinaryOperator<Pair<Integer, Integer>> combiner = (a, b) -> null;

        Pair<Integer, Integer> pair = data.reduce(new Pair<>(0, 0), operator, combiner);
        double average = pair.getFirst().doubleValue() / pair.getSecond();
        System.out.println("Average of elements is " + average);
    }

    private static void averageViaReduceParallel(Stream<Integer> data) {
        BiFunction<Pair<Integer, Integer>, Integer, Pair<Integer, Integer>> operator = (pair, item) -> {
            int newTotal = pair.getFirst() + item;
            int newCount = pair.getSecond() + 1;
            return new Pair<>(newTotal, newCount);
        };

        BinaryOperator<Pair<Integer, Integer>> combiner = (pair1, pair2) -> {
            int newTotal = pair1.getFirst() + pair2.getFirst();
            int newCount = pair1.getSecond() + pair2.getSecond();
            return new Pair<>(newTotal, newCount);
        };

        Pair<Integer, Integer> pair = data
                .parallel()
                .reduce(new Pair<>(0, 0), operator, combiner);
        double average = pair.getFirst().doubleValue() / pair.getSecond();
        System.out.println("Average of elements via parallel reduce is " + average);
    }


    private static void averageViaCollect(Stream<Integer> data) {
        double result = data.collect(averagingDouble(x -> x));
        System.out.println("Average of elements via collect is " + result);
    }

    private static void lastViaReduce(Stream<Integer> data) {
        int result = data.reduce((a, b) -> b)
                .orElseThrow(IllegalStateException::new);
        System.out.println("The last element is " + result);
    }

    private static void penultimateViaReduce(Stream<Integer> data) {
        int[] lastTwoItems = data.reduce(new int[]{0, 0},
                (a, b) -> new int[]{a[1], b},
                (a, b) -> null);
        int penultimateItem = lastTwoItems[0];
        System.out.println("The penultimate elements is " + penultimateItem);
    }

    private static void reverseViaReduce(Stream<Integer> data) {
        ArrayList<Integer> results = data.reduce(
                new ArrayList<>(),
                (newList, item) -> {
                    newList.add(0, item);
                    return newList;
                },
                (a, b) -> null);
        System.out.println("The list in reverse is:");
        for (Integer value : results) {
            System.out.printf("\t%d\n", value);
        }
    }
}
