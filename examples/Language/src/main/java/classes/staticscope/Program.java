package classes.staticscope;

public class Program {
    public static void main(String[] args) throws Exception {
        printDetails("Before Creating Objects");
        TestType[] tstarray = new TestType[100];
        for (int i = 0; i < 100; i++) {
            tstarray[i] = new TestType();
        }
        printDetails("After Creating Objects");
        for (int i = 50; i < 100; i++) {
            tstarray[i] = null;
        }
        printDetails("After Nulling references");
        System.gc();
        Thread.sleep(5000);
        printDetails("After Requesting Garbage Collection");
    }

    private static void printDetails(String title) {
        System.out.println("----- " + title + " -----");
        System.out.println("\tNumber objects created is:\t" + TestType.getNumCreated());
        System.out.println("\tNumber objects in memory is:\t" + TestType.getNumInMemory());
    }
}
