package console.scanner;

import java.util.Scanner;

public class ScannerWithTypes {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number or X to end");
        int total = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                total += scanner.nextInt();
            } else {
                String token = scanner.next();
                if (token.equals("X")) {
                    break;
                } else {
                    System.out.printf("Unexpected input %s - try again\n", token);
                }
            }
        }
        System.out.printf("Total of numbers entered is %d", total);
    }

}
