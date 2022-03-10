package printing;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        printingStrings();
        printingNumbers();
        printingFloats();
        printingDates();
    }

    private static void printingStrings() {
        String myvar1 = "test1";
        String myvar2 = "test2";
        String myvar3 = "test3";

        System.out.println("----- Printing Strings -----");
        System.out.printf("\tValues are %1$s, %2$s and %3$s\n", myvar1, myvar2, myvar3);
        System.out.printf("\tValues are %s, %s and %s\n", myvar1, myvar2, myvar3);
        System.out.printf("\tValues in reverse are %3$s, %2$s and %1$s\n", myvar1, myvar2, myvar3);
        System.out.printf("\tValues with padding are (%10s), (%10s) and (%-10s)\n", myvar1, myvar2, myvar3);
    }

    private static void printingNumbers() {
        int no1 = 100;
        int no2 = 256;
        int no3 = 1024;

        System.out.println("----- Printing Integers -----");
        System.out.printf("\tNumbers in decimal are %1$d, %2$d and %3$d\n", no1, no2, no3);
        System.out.printf("\tNumbers in octal are %1$o, %2$o and %3$o\n", no1, no2, no3);
        System.out.printf("\tNumbers in hex are %1$x, %2$x and %3$x\n", no1, no2, no3);
        System.out.printf("\tTotal is %1$d (%1$o in octal and %1$x in hex)\n", no1 + no2 + no3);
    }

    private static void printingFloats() {
        System.out.println("----- Printing Floats -----");
        System.out.printf("\tValues are: %1$.4f  %2$.4f  %3$.4f  %4$.4f\n", 1.2, 1.23, 1.234, 1.2345);
    }

    private static void printingDates() {
        System.out.println("----- Printing Dates -----");
        Date now = new Date();
        System.out.printf("\tThe time is %1$tT or %2$tr if you prefer\n", now, now);
        System.out.printf("\tThe date is %1$tD or %2$tF if you prefer\n", now, now);
    }
}
