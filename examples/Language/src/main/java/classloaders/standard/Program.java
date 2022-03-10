package classloaders.standard;

public class Program {
    private static String SPACER = "\t";

    public static void main(String[] args) {
        printClassLoaders(Program.class);
        printClassLoaders(String.class);
    }

    private static void printClassLoaders(Class<?> klass) {
        System.out.printf("----- Classloader tree for %s -----\n", klass.getName());
        printClassLoaders(klass.getClassLoader(), 1);
    }

    private static void printClassLoaders(ClassLoader loader, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(SPACER);
        }
        System.out.print(loader);
        if (loader == null) {
            System.out.print(" (bootstrap classloader)");
        }
        System.out.println();
        if (loader != null) {
            printClassLoaders(loader.getParent(), ++depth);
        }
    }
}
