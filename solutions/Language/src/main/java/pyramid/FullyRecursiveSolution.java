package pyramid;

import java.util.Scanner;

public class FullyRecursiveSolution {
	public static void main(String[] args) {
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
		printPyramid(size - 1, 1);
	}
	private static void printPyramid(int numSpaces, int numHashes) {
		if (numSpaces >= 0) {
			printRow(numSpaces, numHashes);
			printPyramid(numSpaces - 1, numHashes + 2);
		}
	}
	private static void printRow(int numSpaces, int numHashes) {
		// print the correct number of spaces
		printTimes(' ', numSpaces);
		// print the correct number of hashes
		printTimes('#', numHashes);
		// take a new line
		System.out.println();
	}
	private static void printTimes(char ch, int times) {
		if(times > 0) {
			System.out.print(ch);
			printTimes(ch, times - 1);
		}
	}
}
