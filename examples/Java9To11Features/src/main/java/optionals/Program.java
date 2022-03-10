package optionals;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class Program {
    private static Optional<String> getProperty(String name) {
        return Optional.ofNullable(System.getProperty(name));
    }

    public static void main(String[] args) {
        showOr();
        showIfPresentOrElse();
        showConvertingToStream();
        showOrElseThrow();
        showIsEmpty();
    }

    private static void showOr() {
        printTitle("Using 'or' (Java 9)");

        getProperty("java.version")
                .or(() -> Optional.of("No Such Property"))
                .map(s -> "Outcome is: " + s)
                .ifPresent(Program::printTabbed);

        getProperty("wibble.wobble")
                .or(() -> Optional.of("No Such Property"))
                .map(s -> "Outcome is: " + s)
                .ifPresent(Program::printTabbed);

    }

    private static void showIfPresentOrElse() {
        printTitle("Using 'ifPresentOrElse' (Java 9)");

        getProperty("java.version")
                .ifPresentOrElse(
                        Program::printTabbed,
                        () -> printTabbed("No Such Property"));

        getProperty("wibble.wobble")
                .ifPresentOrElse(
                        Program::printTabbed,
                        () -> printTabbed("No Such Property"));

    }

    private static void showConvertingToStream() {
        printTitle("Converting Optionals to Streams (Java 9)");

        Optional<String> op1 = getProperty("java.version");
        Optional<String> op2 = getProperty("wibble.wobble");

        Stream<String> stream1 = op1.stream();
        Stream<String> stream2 = op2.stream();

        stream1.map(s -> "Successfully found " + s)
                .forEach(Program::printTabbed);

        stream2.map(s -> "Successfully found " + s)
                .forEach(Program::printTabbed);
    }

    private static void showOrElseThrow() {
        Optional<String> op1 = getProperty("java.version");
        Optional<String> op2 = getProperty("wibble.wobble");

        printTitle("The 'orElseThrow' Method (Java 10)");
        printTabbed(op1.orElseThrow());
        try {
            printTabbed(op2.orElseThrow());
        } catch (NoSuchElementException ex) {
            printTabbed("No property called 'wibble.wobble'");
        }
    }

    private static void showIsEmpty() {
        printTitle("The 'isEmpty' Method (Java 11)");

        Optional<String> op1 = getProperty("java.version");
        Optional<String> op2 = getProperty("wibble.wobble");

        if (!op1.isEmpty()) {
            printTabbed(op1.get());
        }
        if (!op2.isEmpty()) {
            printTabbed(op2.get());
        }
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
