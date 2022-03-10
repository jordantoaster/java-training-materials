package switching.expressions.one;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Simpson");
        String simpson = scanner.nextLine();


        switchExpressionsWithRules(simpson);
        switchExpressionsWithBlockRules(simpson);
        switchExpressionsWithLabels(simpson);
    }

    private static void switchExpressionsWithRules(String simpson) {
        String message = switch (simpson) {
            case "Homer", "Marge" -> "One of the adults";
            case "Bart", "Liza", "Maggie" -> "One of the kids";
            case "Snowball", "Santa's Little Helper" -> "One of the pets";
            default -> "Not a Simpson - DOH!";
        };
        System.out.println(message);
    }

    private static void switchExpressionsWithBlockRules(String simpson) {
        String message = switch (simpson) {
            case "Homer", "Marge" -> {
                System.out.println("Option 1");
                yield "One of the adults";
            }
            case "Bart", "Liza", "Maggie" -> {
                System.out.println("Option 2");
                yield "One of the kids";
            }
            case "Snowball", "Santa's Little Helper" -> {
                System.out.println("Option 3");
                yield "One of the pets";
            }
            default -> {
                System.out.println("Default Option");
                yield "Not a Simpson - DOH!";
            }
        };
        System.out.println(message);
    }

    private static void switchExpressionsWithLabels(String simpson) {
        String message = switch (simpson) {
            case "Homer", "Marge":
                yield "One of the adults";
            case "Bart", "Liza", "Maggie":
                yield "One of the kids";
            case "Snowball", "Santa's Little Helper":
                yield "One of the pets";
            default:
                yield "Not a Simpson - DOH!";
        };
        System.out.println(message);
    }
}
