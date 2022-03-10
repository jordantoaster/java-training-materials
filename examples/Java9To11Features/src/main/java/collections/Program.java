package collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalDate.ofYearDay;

public class Program {
    public static void main(String[] args) {
        showFactoryMethods();
        showCopyingCollections();
        showBuildingFromStreams();
        showConvertingToArrays();
    }

    private static void showBuildingFromStreams() {
        Supplier<Stream<String>> f = () -> Stream.of("Fred", "Wilma", "Pebbles");

        printTitle("Converting Streams to Unmodifiable Lists (Java 10)");
        List<String> data1 = f.get().collect(Collectors.toList());
        List<String> data2 = f.get().collect(Collectors.toUnmodifiableList());

        try {
            data1.add("Dino");
            printTabbed("Output of 'toList' is mutable");
        } catch (UnsupportedOperationException ex) {
            printTabbed("Output of 'toList' is immutable");
        }

        try {
            data2.add("Dino");
            printTabbed("Output of 'toUnmodifiableList' is mutable");
        } catch (UnsupportedOperationException ex) {
            printTabbed("Output of 'toUnmodifiableList' is immutable");
        }
    }

    private static void showFactoryMethods() {
        printTitle("Building Lists via Factory Methods (Java 9)");
        List<String> data1 = List.of("Fred", "Wilma", "Barney", "Betty");
        data1.forEach(Program::printTabbed);

        printTitle("Building Sets via Factory Methods (Java 9)");
        Set<String> data2 = Set.of("Fred", "Wilma", "Barney", "Betty");
        data2.forEach(Program::printTabbed);

        printTitle("Building Maps via Factory Methods (Java 9)");
        Map<String, LocalDate> data3 = Map.of(
                "Moonlight", ofYearDay(2017, 1),
                "Spotlight", ofYearDay(2016, 1),
                "Birdman", ofYearDay(2015, 1),
                "12 Years a Slave", ofYearDay(2014, 1),
                "Argo", ofYearDay(2013, 1));
        data3.forEach(Program::printTabbed);

        Map<String, LocalDate> data4 = Map.ofEntries(
                Map.entry("Moonlight", ofYearDay(2017, 1)),
                Map.entry("Spotlight", ofYearDay(2016, 1)),
                Map.entry("Birdman", ofYearDay(2015, 1)),
                Map.entry("12 Years a Slave", ofYearDay(2014, 1)),
                Map.entry("Argo", ofYearDay(2013, 1)));
        data4.forEach(Program::printTabbed);
    }

    private static void showCopyingCollections() {
        List<String> originalData = new ArrayList<>();
        originalData.add("Grumpy");
        originalData.add("Sneezy");
        originalData.add("Bashful");

        printTitle("Copying Collections (Java 10)");
        List<String> copy = List.copyOf(originalData);
        try {
            copy.add("Sleepy");
            printTabbed("Copied collection is mutable");
        } catch (UnsupportedOperationException ex) {
            printTabbed("Copied collection is immutable");
        }
    }

    private static void showConvertingToArrays() {
        printTitle("Building Arrays from Lists (Java 11)");
        List<String> listData = List.of("Fred", "Wilma", "Barney", "Betty");
        String[] arrayData = listData.toArray(String[]::new);
        for (String str : arrayData) {
            printTabbed(str);
        }
    }

    private static void printTabbed(String str) {
        System.out.printf("\t%s\n", str);
    }

    private static void printTabbed(String str, LocalDate date) {
        System.out.printf("\t%s and %s\n", str, date.getYear());
    }

    private static void printTitle(String title) {
        System.out.print("------ ");
        System.out.print(title);
        System.out.println(" ------");
    }
}
