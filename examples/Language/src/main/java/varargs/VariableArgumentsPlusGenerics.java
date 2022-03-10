package varargs;

public class VariableArgumentsPlusGenerics {
    public static void main(String[] args) {
        System.out.println("Biggest int is: " + largest(10, 20, 50, 40, 30));
        System.out.println("Biggest String is: " + largest("aa", "bb", "xx", "cc", "dd"));
    }

    public static <T extends Comparable<T>> T largest(T... args) {
        T chosen = args[0];
        for (int i = 1; i < args.length; i++) {
            if (chosen.compareTo(args[i]) < 0) {
                chosen = args[i];
            }
        }
        return chosen;
    }
}
