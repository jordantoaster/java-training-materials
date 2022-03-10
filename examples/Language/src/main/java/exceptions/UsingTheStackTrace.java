package exceptions;

public class UsingTheStackTrace {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        try {
            op1();
        } catch (Exception ex) {
            System.out.println("Main Just caught: " + ex.getClass().getName());
            System.out.println("Stack trace is:");
            for (StackTraceElement e : ex.getStackTrace()) {
                System.out.println("\t" + e);
            }
        }
        System.out.println("End of Main");
    }

    private static void op1() {
        System.out.println("\tStart of OP1");
        op2();
        System.out.println("\tEnd of OP1");
    }

    private static void op2() {
        System.out.println("\t\tStart of OP2");
        op3();
        System.out.println("\t\tEnd of OP2");
    }

    private static void op3() {
        System.out.println("\t\t\tStart of OP3");
        op4();
        System.out.println("\t\t\tEnd of OP3");
    }

    private static void op4() {
        System.out.println("\t\t\t\tStart of OP4");
        if (Math.random() < 0.5) {
            throw new IllegalArgumentException();
        }
        System.out.println("\t\t\t\tEnd of OP4");
    }
}
