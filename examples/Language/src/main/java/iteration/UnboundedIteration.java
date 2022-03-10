package iteration;

public class UnboundedIteration {
    public static void main(String[] args) {
        showWhileLoop();
        showInfiniteLoop();
        showDoWhileLoop();
    }

    private static void showWhileLoop() {
        System.out.println("--- While Loop ---");
        double value = 0;
        while (value < 0.75) {
            value = Math.random();
            System.out.println("\tNumber is: " + value);
        }
    }

    private static void showDoWhileLoop() {
        double value;
        System.out.println("--- Do While Loop ---");
        do {
            value = Math.random();
            System.out.println("\tNumber is: " + value);
        } while (value < 0.75);
    }

    private static void showInfiniteLoop() {
        double value;
        System.out.println("--- Infinite While Loop ---");
        while (true) {
            value = Math.random();
            System.out.println("\tNumber is: " + value);
            if (value >= 0.75) {
                break;
            }
        }
    }
}

