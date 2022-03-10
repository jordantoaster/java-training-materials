package iteration;

public class UsingLabelledBreaks {
    public static void main(String[] args) {
        int val1 = 1;
        int val2 = 27;
        FRED:
        while (true) {
            while (true) {
                val1++;
                if (val1 % 3 == 0) {
                    break;
                } else if (val1 > val2) {
                    break FRED;
                }
                System.out.println("Inner [" + val1 + "]");
            }
            System.out.println("Outer [" + val1 + "]");
        }
        System.out.println("All done - bye...");
    }
}
