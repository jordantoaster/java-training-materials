package streams;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        Supplier<Stream<String>> f = () -> Stream.of(
                "Fred", "Wilma", "Pebbles",
                "Dino", "Barney", "Betty"
        );

        showReversingPredicate(f.get());
        showTakeWhile(f.get());
        showDropWhile(f.get());
        showOfNullable();
    }

    private static void showReversingPredicate(Stream<String> input) {
        printTitle("Show Reversing Predicates (Java 11)");
        input.filter(Predicate.not(s -> s.length() == 5))
                .forEach(Program::printTabbed);
    }

    private static void showTakeWhile(Stream<String> input) {
        printTitle("Show 'takeWhile' Method (Java 9)");

        input.takeWhile(s -> s.length() < 7)
                .forEach(Program::printTabbed);
    }

    private static void showDropWhile(Stream<String> input) {
        printTitle("Show 'dropWhile' Method (Java 9)");

        input.dropWhile(s -> s.length() < 7)
                .forEach(Program::printTabbed);
    }

    private static void showOfNullable() {
        Stream<String> stream1 = Stream.ofNullable("abc");
        Stream<String> stream2 = Stream.ofNullable(null);

        printTitle("Show 'ofNullable' Method (Java 9)");
        stream1.forEach(Program::printTabbed);
        stream2.forEach(Program::printTabbed);
    }

    private static void printTabbed(String str) {
        System.out.printf("\t%s\n", str);
    }

    private static void printTitle(String title) {
        System.out.print("------ ");
        System.out.print(title);
        System.out.println(" ------");
    }
}
