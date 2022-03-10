package words.clean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) throws IOException {
        Path path = new File("./data/uniqueWords.txt").toPath();
        Stream<String> lines = Files.lines(path);
        lines.forEach(System.out::println);
    }
}
