package streams.parallel;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String [] args) {
        List<Integer> input = Arrays.asList(30,26,22,18,14,10);
        input.stream()
             .parallel() //try with this removed
             .map(Program::waitAndReturn)
             .forEach(System.out::println);
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
