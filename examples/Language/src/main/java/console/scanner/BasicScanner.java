package console.scanner;

import java.util.Scanner;

public class BasicScanner {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentLine;
        while (true) {
            System.out.println("Type something (XXX to end) ...");
            currentLine = scanner.next();
            if (currentLine.equals("XXX")) {
                break;
            } else {
                System.out.println("You typed: " + currentLine);
            }
        }
        System.out.println("End of program");
    }
}
