package pyramid;

import java.util.Scanner;

public class StandardSolution {
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
		printPyramid(size);
	}

	static void printPyramid(int size) {
		// the number of hashes to be printed in the current row
		int numHashes = 1;
		// for each row in the pyramid...
		for (int rows = 1; rows <= size; rows++) {
			int numSpaces = size - rows;
			// print the correct number of spaces
			for (int spaces = 0; spaces < numSpaces; spaces++) {
				System.out.print(" ");
			}
			// print the correct number of hashes
			for (int hashes = 0; hashes < numHashes; hashes++) {
				System.out.print("#");
			}
			// take a new line
			System.out.println();
			// adjust the number of hashes
			numHashes += 2;
		}
	}
}
