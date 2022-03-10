package streams.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Program {
	private static final Path PATH = FileSystems.getDefault().getPath("data");
	
	public static void main(String[] args) throws IOException {
		try(Stream<Path> folderContent = Files.list(PATH)) {
			System.out.println("Here are the folders contents");
			folderContent.forEach(Program::printPath);
		}
		System.out.println("\nHere are the first five lines from each file");
		Files.list(PATH)
			 .filter(p -> p.toFile().isFile())
			 .flatMap(p -> readLines(p).limit(5))
			 .forEach(System.out::println);
	}
	private static Stream<String> readLines(Path p) {
		try {
			return Files.lines(p);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	private static void printPath(Path path) {
		File file = path.toFile();
		if(file.isDirectory()) {
			System.out.println("\tNested folder: " + path);
		} else if(file.isFile()) {
			System.out.println("\tThe file: " + path);
		}
	}	
}
