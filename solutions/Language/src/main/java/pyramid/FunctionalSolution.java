package pyramid;

import java.util.Scanner;

import static java.util.stream.IntStream.rangeClosed;

public class FunctionalSolution {
	public static void main(String[] args) {
		int size = readSize();
		printPyramid(size);
		printPyramidFaulty(size);
	}

	private static int readSize() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the pyramid");
		int size = 0;
		while(scanner.hasNext()) {
			if(scanner.hasNextInt()) {
				size = scanner.nextInt();
				break;
			} else {
				System.out.println(scanner.next() + " " + " is invalid - try again");
			}
		}
		return size;
	}

	private static void printPyramid(int size) {
		System.out.println("Here is the pyramid (correct version)");
		rangeClosed(1,size)
                .parallel()
                .mapToObj(num -> buildRow(size, num))
                .map(FunctionalSolution::prependThreadId)
                .reduce((a,b) -> a + b)
                .ifPresent(System.out::println);
	}
	private static void printPyramidFaulty(int size) {
		System.out.println("Here is the pyramid (faulty version)");
		rangeClosed(1,size)
				.parallel()
				.mapToObj(num -> buildRow(size, num))
				.map(FunctionalSolution::prependThreadId)
				.forEach(System.out::print);
	}

	private static String prependThreadId(String str) {
	    return String.format("%s\t%s\n", threadId(), str);
    }

	private static String threadId() {
	    return String.valueOf(Thread.currentThread().getId());
    }

    private static String buildRow(int size, int rowNum) {
        int numSpaces = size - rowNum;
        int numHashes = (rowNum * 2) - 1;

        String spaces = repeat(numSpaces, " ");
        String hashes = repeat(numHashes, "#");
        return spaces + hashes;
    }

    private static String repeat(int num, String text) {
        return rangeClosed(1,num)
                .mapToObj(n -> text)
                .reduce((a,b) -> a + b)
                .orElse("");
    }
}
