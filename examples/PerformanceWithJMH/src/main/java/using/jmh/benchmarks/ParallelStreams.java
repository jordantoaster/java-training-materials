package using.jmh.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;

@State(Scope.Benchmark)
public class ParallelStreams {
    private static final String FILE_PATH = "./data/TheThreeMuskateers.txt";
    private static final String REGEX = "^[a-z ]+$";

    private static List<String> lines = readLinesFromFile();
    public volatile long result = 0;

    @Benchmark
    public void findingAndCountingLinesInSequence() {
        result = lines.stream()
                .filter(line -> line.matches(REGEX))
                .collect(summarizingInt(String::length))
                .getSum();
    }
    @Benchmark
    public void findingAndCountingLinesInParallel() {
        result = lines.parallelStream()
                .filter(line -> line.matches(REGEX))
                .collect(summarizingInt(String::length))
                .getSum();
    }
    private static List<String> readLinesFromFile() {
        List<String> result  = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            result = reader.lines().collect(toList());
        } catch (IOException ex) {
            System.err.println("Whoops! " + ex.getMessage());
        }
        return result;
    }
}
