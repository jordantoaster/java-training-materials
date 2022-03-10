package demos.completable.future.syntax;

import java.util.concurrent.CompletableFuture;

public class Program {
    public static void main(String[] args) {
        generateFirst()
                .thenCompose(Program::generateNext)
                .thenCompose(Program::generateNext)
                .thenApply(Program::generateLast)
                .thenAccept(num -> print("Final value is " + num))
                .thenRun(() -> print("Job done"));
    }

    private static CompletableFuture<Double> generateFirst() {
        return CompletableFuture.supplyAsync(Math::random);
    }

    private static CompletableFuture<Double> generateNext(Double input) {
        return CompletableFuture.supplyAsync(() -> input * 10);
    }

    private static Double generateLast(Double input) {
        return input * 10;
    }

    private static void print(String thing) {
        System.out.println(thing);
    }
}
