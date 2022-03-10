package exceptions;

public class FinallyQuirks {

    public static void main(String[] args) {
        System.out.println("Method op1 returns: " + op1());
        try {
            op2();
        } catch (Exception ex) {
            System.out.println("Method op2 threw: " + ex);
        }
    }

    private static boolean op1() {
        try {
            return false;
        } finally {
            if (Math.random() > 0.5) {
                return true;
            }
        }
    }

    private static void op2() {
        try {
            throw new IllegalArgumentException();
        } finally {
            if (Math.random() > 0.5) {
                throw new IllegalStateException();
            }
        }
    }
}