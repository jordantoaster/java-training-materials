package call.stack;

public class Program {
    public static void main(String[] args) {
        m1();
    }
    private static void m1() {
        m2();
    }
    private static void m2() {
        m3();
    }
    private static void m3() {
        m4();
    }
    private static void m4() {
        m5();
    }
    private static void m5() {
        StackTraceElement [] theCallStack = Thread.currentThread().getStackTrace();
        for(StackTraceElement e : theCallStack) {
            String methodName = e.getMethodName();
            String className = e.getClassName();
            int lineNumber = e.getLineNumber();
            System.out.printf("%s in %s at line %s\n", methodName, className, lineNumber);
        }
    }
}

