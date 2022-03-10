package strings;

import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        showRepeat();
        showIsBlank();
        showLines();
    }

    private static void showLines() {
        String tst = "Blake\nJenna\nAvon\nCally\nVilla\nSoolin";

        printTitle("Show 'repeat' (Java 11)");
        Stream<String> stream = tst.lines();
        stream.forEach(Program::printTabbed);
    }

    private static void showRepeat() {
        printTitle("Show 'repeat' (Java 11)");
        String tst = "Coffee ";
        printTabbed(tst.repeat(5));
    }

    private static void showIsBlank() {
        String tst1 = "";
        String tst2 = "   ";
        String tst3 = "\t\t\t";
        String tst4 = "wibble";
        String[] data = {tst1, tst2, tst3, tst4};

        printTitle("Show 'isBlank' (Java 11)");
        for (String str : data) {
            String msg;
            if (str.isBlank()) {
                msg = String.format("'%s' is blank\n", str);
            } else {
                msg = String.format("'%s' is NOT blank\n", str);
            }
            printTabbed(msg);
        }
    }

    private static void printTabbed(String str) {
        System.out.printf("\t%s\n", str);
    }

    private static void printTitle(String title) {
        System.out.print("------ ");
        System.out.print(title);
        System.out.println(" ------");
    }
}
