package words;

import util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static final String FILE_PATH = "./data/uniqueWords.txt";

    public static void main(String[] args) throws IOException {
        Stream<String> lines = readLinesFromFile(FILE_PATH)
                .orElseThrow(Program::buildError);

        List<Pair<String, Integer>> wordsListed = listWordsByFrequency(lines);
        Collections.reverse(wordsListed);
        printWordFrequencies(wordsListed);
    }

    private static RuntimeException buildError() {
        return new IllegalStateException("File path incorrect");
    }

    private static void printWordFrequencies(List<Pair<String, Integer>> words) {
        words.forEach(pair -> System.out.printf("'%s' occurred %d times\n", pair.getFirst(), pair.getSecond()));
    }

    private static List<Pair<String, Integer>> listWordsByFrequency(Stream<String> lines) {
        Map<String, List<String>> wordsTabulated = tabulateWords(lines);

        return wordsTabulated
                .entrySet()
                .stream()
                .map(Program::convertEntryToPair)
                .filter(Program::occursMoreThanOnce)
                .sorted(frequencySorter())
                .collect(Collectors.toList());
    }

    private static Pair<String, Integer> convertEntryToPair(Map.Entry<String, List<String>> entry) {
        return new Pair<>(entry.getKey(), entry.getValue().size());
    }

    private static boolean occursMoreThanOnce(Pair<String, Integer> pair) {
        return pair.getSecond() > 1;
    }

    private static Comparator<Pair<String, Integer>> frequencySorter() {
        return Comparator.comparingInt(Pair::getSecond);
    }

    private static Map<String, List<String>> tabulateWords(Stream<String> lines) {
        return lines.flatMap(Program::splitLineIntoWords)
                .map(Program::normalizeWord)
                .filter(Program::notJustDigits)
                .collect(Collectors.groupingBy(word -> word));
    }

    private static Optional<Stream<String>> readLinesFromFile(String filePath) {
        Path path = new File(filePath).toPath();
        try {
            Stream<String> lines = Files.lines(path);
            return Optional.of(lines);
        } catch(IOException ex) {
            return Optional.empty();
        }
    }

    private static String normalizeWord(String word) {
        return word.toLowerCase().replaceAll("\\W", "");
    }

    private static Stream<String> splitLineIntoWords(String line) {
        return Arrays.stream(line.split("\\s+"));
    }

    private static boolean notJustDigits(String word) {
        return !word.matches("^[0-9]+$");
    }
}
