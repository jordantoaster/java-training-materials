package arrays;

import java.util.stream.IntStream;
import static java.lang.String.format;

public class CommandLineParameters {

	public static void main(String[] args) {
		System.out.println("Command Line Parameters Are: ");
		IntStream.range(0, args.length)
				.mapToObj(i -> format("\tArgument %d is %s", i, args[i]))
				.forEachOrdered(System.out::println);
	}
}

