package roman.numerals;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number to convert (or non number to end)");
            if (!input.hasNextInt()) {
                break;
            }
            int number = input.nextInt();
            System.out.printf("%d as a roman numeral is: %s\n", number, "XXX");
        }
        System.out.println("Bye...");
    }

}
