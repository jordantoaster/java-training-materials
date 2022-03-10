package arrays;

import java.util.Arrays;

public class ArraysOfPrimitiveTypes {

    public static void main(String[] args) {
        showFullArraySyntax();
        printLine();
        showShorthandSyntax();
        printLine();
        showErrorHandling();
    }

    private static void showErrorHandling() {
        int [] sample = new int[]{10, 20, 30};
        try {
            int tmp = sample[sample.length];
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Just caught: " + ex.getMessage());
        }
    }

    private static void printLine() {
        System.out.println("-----------------");
    }

    private static void showShorthandSyntax() {
        int [] sample1 = new int[]{1001,1002,1003};
        int [] sample2 = {2001,2002,2003,2004};

        printArrayV1(sample1);
        printArrayV2(sample1);
        printArrayV3(sample1);

        printArrayV1(sample2);
        printArrayV2(sample2);
        printArrayV3(sample2);
    }

    private static void showFullArraySyntax() {
        int[] sample = new int[5];
        sample[0] = 101;
        sample[1] = 202;
        sample[2] = 303;
        sample[3] = 404;
        sample[4] = 505;

        printArrayV1(sample);
        printArrayV2(sample);
        printArrayV3(sample);
    }

    private static void printArrayV1(int[] input) {
        System.out.println("------------------");
        System.out.println("First element is: " + input[0]);
        System.out.println("Last element is: " + input[input.length - 1]);

        System.out.println("Full contents are:");
        for(int i=0;i<input.length;i++) {
            System.out.println("\t" + input[i]);
        }
    }

    private static void printArrayV2(int[] input) {
        System.out.println("------------------");
        System.out.println("First element is: " + input[0]);
        System.out.println("Last element is: " + input[input.length - 1]);

        System.out.println("Full contents are:");
        for(int value : input) {
            System.out.println("\t" + value);
        }
    }

    private static void printArrayV3(int[] input) {
        System.out.println("------------------");
        System.out.println("First element is: " + input[0]);
        System.out.println("Last element is: " + input[input.length - 1]);
        System.out.println("Full contents are:");

        Arrays.stream(input)
                .mapToObj(value -> "\t" + value)
                .forEach(System.out::println);
    }
}

