package varargs;

public class VariableArguments {
    public static void main(String[] args) {
        System.out.println("Total is: " + total(10, 20, 30, 40, 50));
        System.out.println("Total is: " + total(10, 20, 30, 40, 50, 60));
        System.out.println("Total is: " + total(10, 20, 30, 40, 50, 60, 70, 80));
        System.out.println("Total is: " + total(10, 20, 30, 40, 50, 60, 70, 80, 90));
    }

    public static int total(int... args) {
        int total = 0;
        for (int i : args) {
            total += i;
        }
        return total;
    }
}
