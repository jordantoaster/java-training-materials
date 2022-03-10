package console.scanner;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerWithRegex {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Pattern accountNoRegex = Pattern.compile("[A-Z]{3}-[0-9]{3}-[A-Z]{3}");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number:");
        while (scanner.hasNext()) {
            if (scanner.hasNext(accountNoRegex)) {
                String acccountNo = scanner.next();
                System.out.printf("Account number %s recognized\n", acccountNo);
                break;
            } else {
                System.out.printf("Invalid account number %s - try again\n", scanner.next());
            }
        }
        System.out.println("End of program");
    }

}
