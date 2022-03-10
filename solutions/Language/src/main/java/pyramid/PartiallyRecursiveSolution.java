package pyramid;

import java.util.Scanner;

public class PartiallyRecursiveSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the pyramid");
        int size = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
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
        for (int spaces = 0; spaces < numSpaces; spaces++) {
            System.out.print(" ");
        }
        // print the correct number of hashes
        for (int hashes = 0; hashes < numHashes; hashes++) {
            System.out.print("#");
        }
        // take a new line
        System.out.println();
    }
}
