package switching.labels;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Simpson");
        String simpson = scanner.nextLine();

        switch(simpson) {
            case "Homer", "Marge":
                System.out.println("One of the adults");
                break;
            case "Bart", "Liza", "Maggie":
                System.out.println("One of the kids");
                break;
            case "Snowball", "Santa's Little Helper":
                System.out.println("One of the pets");
                break;
            default:
                System.out.println("Not a Simpson - DOH!");
        }
    }
}
