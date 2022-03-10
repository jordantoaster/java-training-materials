package iteration;

public class BoundedIteration {
    public static void main(String[] args) {
        showForLoopUpwards();
        showForLoopDownwards();
        showMultipleCounters();
        showInfiniteLoop();
    }

    private static void showForLoopUpwards() {
        System.out.println("--- For Loop Upwards---");
        for (int counter = 0; counter < 10; counter++) {
            System.out.println("\tLoop " + counter);
        }
    }

    private static void showForLoopDownwards() {
        System.out.println("--- For Loop Downwards---");
        for (int counter = 10; counter > 0; counter--) {
            System.out.println("\tLoop " + counter);
        }
    }

    private static void showMultipleCounters() {
        System.out.println("--- For Loop With Multiple Counters ---");
        for (int x = 1, y = 20; x < y; x++, y--) {
            System.out.println("\t[x=" + x + " y=" + y + "]");
        }
    }

    private static void showInfiniteLoop() {
        System.out.println("--- Infinite For Loop ---");
        for (; ; ) {
            double value = Math.random();
            System.out.println("\tNumber is: " + value);
            if (value >= 0.75) {
                break;
            }
        }
    }
}

