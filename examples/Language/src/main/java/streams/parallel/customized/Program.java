package streams.parallel.customized;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {
        ForkJoinPool pool1 = new ForkJoinPool(2);
        ForkJoinPool pool2 = new ForkJoinPool(2);

        List<Integer> input1 = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        List<Integer> input2 = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);

        CompletableFuture<List<String>> iou1 = supplyAsync(() -> processValues(input1), pool1);
        CompletableFuture<List<String>> iou2 = supplyAsync(() -> processValues(input2), pool2);

        List<String> result1 = iou1.join();
        result1.stream().forEach(System.out::println);
        System.out.println("-------------------");
        List<String> result2 = iou2.join();
        result2.stream().forEach(System.out::println);
    }

    private static List<String> processValues(List<Integer> input) {
        return input.stream()
                .parallel()
                .map(Program::waitAndReturn)
                .collect(toList());
    }

    private static String waitAndReturn(Integer sleep) {
        goToSleep(sleep);
        return buildMessage(sleep);
    }

    private static void goToSleep(Integer sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException ex) {
            System.out.println("BANG! " + ex.getMessage());
        }
    }

    private static String buildMessage(Integer sleep) {
        String msg = "Thread %d just returned after %d secs";
        long threadId = Thread.currentThread().getId();

        return String.format(msg, threadId, sleep);
    }
}
