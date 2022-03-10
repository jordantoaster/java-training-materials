package inference;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        inferenceOnDeclarations();
        inferenceOnForLoop();
        inferenceOnForEachLoop();
        inferenceInLambdas();
    }

    private static void inferenceOnDeclarations() {
        printTitle("Inference on Variable Declarations (Java 10)");
        var tst1 = 12;
        var tst2 = 34.5;
        var tst3 = "abcde";
        var tst4 = LocalDate.now();
        var tst5 = new String[]{"ab", "cd", "ef"};

        printWithType(tst1);
        printWithType(tst2);
        printWithType(tst3);
        printWithType(tst4);
        printTabbed(tst5);
    }

    private static void inferenceOnForLoop() {
        String[] data = {"Fred", "Wilma", "Barney", "Betty"};

        printTitle("Inference on For Loop (Java 10)");
        for (var i = 0; i < data.length; i++) {
            printTabbed(data[i]);
        }
    }

    private static void inferenceOnForEachLoop() {
        String[] data = {"Fred", "Wilma", "Barney", "Betty"};

        printTitle("Inference on For-Each Loop (Java 10)");
        for (var str : data) {
            printTabbed(str);
        }
    }

    private static void inferenceInLambdas() {
        printTitle("Inference on Lambdas (Java 11)");
        Stream.of("Fred", "Wilma", "Barney", "Betty")
                .map(s -> s + "**")
                .map((var s) -> "*" + s)
                .map((@Test var s) -> "*" + s)
                .forEach(Program::printTabbed);
    }

    private static void printWithType(Object thing) {
        System.out.printf(
                "\t%s of type %s\n",
                thing,
                thing.getClass().getName());
    }

    private static void printTabbed(Object thing) {
        System.out.printf("\t%s\n", thing);
    }

    private static void printTitle(String title) {
        System.out.print("------ ");
        System.out.print(title);
        System.out.println(" ------");
    }
}
