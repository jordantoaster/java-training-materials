package streams.single.usage;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Program {
    public static void main(String[] args) {
        Stream<String> stream = stream(new String[]{"ab", "cd", "ef"});
        System.out.println("First iteration of stream...");
        stream.forEach(System.out::println);
        System.out.println("Second iteration of stream...");
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException ex) {
            System.err.println("Whoops should not have done that...");
        }
    }
}
