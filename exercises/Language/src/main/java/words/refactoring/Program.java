package words.refactoring;

import util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) throws IOException {
        Path path = new File("./data/uniqueWords.txt").toPath();
        Stream<String> lines = Files.lines(path);
        Map<String, List<String>> tabularResults = lines.map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .map(str -> str.replaceAll("\\W", ""))
                .filter(str -> !str.matches("^[0-9]+$"))
                .collect(Collectors.groupingBy(word -> word));

        List<Pair<String, Integer>> listResults = new ArrayList<>();
        tabularResults.forEach((word, instances) -> {
            if(instances.size() > 1) {
                listResults.add(new Pair<>(word, instances.size()));
            }
        });
        listResults.sort(Comparator.comparingInt(Pair::getSecond));
        Collections.reverse(listResults);

        listResults.stream()
                .map(pair -> String.format("%s %d", pair.getFirst(), pair.getSecond()))
                .forEach(System.out::println);
    }
}
