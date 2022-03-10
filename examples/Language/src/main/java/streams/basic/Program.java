package streams.basic;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<String> data = Arrays.asList(
                "ab", "cde", "fghi",
                "jk", "lmn", "opqr",
                "st", "uvw", "xyz");

        printTitle("Using ForEach");
        demoForEach(data);
        printTitle("Using Filter");
        demoFilter(data);
        printTitle("Using Map");
        demoMap(data);
        printTitle("Using MapToInt");
        demoMapToInt(data);
        printTitle("Using Reduce");
        demoReduce(data);
        printTitle("Testing");
        demoTesting(data);
        printTitle("Using FlatMap");
        demoFlatMap(data);
    }

    private static void demoFilter(List<String> data) {
        data.stream()
                .filter(s -> s.length() > 2)
                .forEach(Program::printTabbed);
    }

    private static void demoForEach(List<String> data) {
        data.stream().forEach(Program::printTabbed);
        data.forEach(Program::printTabbed);
    }

    private static void demoMap(List<String> data) {
        data.stream()
                .map(String::length)
                .forEach(Program::printTabbed);
    }

    private static void demoMapToInt(List<String> data) {
        data.stream()
                .map(String::length)
                .reduce((a, b) -> a + b)
                .ifPresent(Program::printTabbed);

        printTabbed(data.stream()
                .mapToInt(String::length)
                .sum());
    }

    private static void demoTesting(List<String> data) {
        boolean result1 = data.stream().allMatch(s -> s.length() > 3);
        boolean result2 = data.stream().anyMatch(s -> s.length() > 3);
        boolean result3 = data.stream().noneMatch(s -> s.length() > 3);

        printTabbed(result1);
        printTabbed(result2);
        printTabbed(result3);
    }

    private static void demoFlatMap(List<String> data) {
        data.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(num -> (char) num)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void demoReduce(List<String> data) {
        data.stream()
                .mapToInt(String::length)
                .reduce((a, b) -> a + b)
                .ifPresent(Program::printTabbed);

        String result = data.stream()
                .reduce(new StringBuilder(),
                        (sb, item) -> sb.append(item),
                        (a, b) -> null)
                .toString();
        System.out.println(result);
    }

    private static void printTitle(String title) {
        System.out.printf("------------ %s -----------\n", title);
    }

    private static void printTabbed(Object thing) {
        System.out.println("\t" + thing);
    }
}
