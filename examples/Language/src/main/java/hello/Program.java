package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter some numbers or three 'X' to finish");
        Pattern endOfInput = Pattern.compile("[X]{3}");
        while (scanner.hasNextLine()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else if (scanner.hasNext(endOfInput)) {
                break;
            } else {
                String mysteryText = scanner.nextLine();
                System.out.printf("Don't understand %s so ignoring...\n", mysteryText);
            }
        }
        int total = numbers.stream()
                .reduce((a, b) -> a + b)
                .orElse(0);
        System.out.printf("Total of numbers is: %s\n", total);
    }
}