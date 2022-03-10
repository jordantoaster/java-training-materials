package pyramid;

import java.util.Scanner;

public class Program {

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
        System.out.println("Here is a pyramid of size " + size);
    }

}
