package exceptions;

public class RuntimeExceptions {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        try {
            op1();
        } catch (Exception ex) {
            System.out.println("Main Just caught: " + ex);
        } finally {
            System.out.println("In Finally Block");
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

