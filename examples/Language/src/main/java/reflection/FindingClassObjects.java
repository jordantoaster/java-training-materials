package reflection;

public class FindingClassObjects {
    public static void main(String[] args) throws Exception {
        Class<?> klass1 = String.class;
        Class<?> klass2 = "abc".getClass();
        String name = "java.lang.String";
        Class<?> klass3 = Class.forName(name);

        printClassDetails(klass1);
        printClassDetails(klass2);
        printClassDetails(klass3);
    }

    private static void printClassDetails(Class<?> klass) {
        System.out.print(klass.getName());
        System.out.print(" in package ");
        System.out.print(klass.getPackage().getName());
        System.out.print(" inheriting from ");
        System.out.println(klass.getSuperclass().getName());
    }
}
