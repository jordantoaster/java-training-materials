/*
 * Created on Feb 3, 2005
 *
 */

package classes.constructors;

public class Program {

    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFour();
    }

    private static void testFour() {
        System.out.println("----- Three Args Constructor -----");
        Derived c4 = new Derived("abc", "def", "ghi");
        System.out.println(c4);
    }

    private static void testThree() {
        System.out.println("----- Two Args Constructor -----");
        Derived c3 = new Derived("abc", "def");
        System.out.println(c3);
    }

    private static void testTwo() {
        System.out.println("----- Single Arg Constructor -----");
        Derived c2 = new Derived("abc");
        System.out.println(c2);
    }

    private static void testOne() {
        System.out.println("----- No Args Constructor -----");
        Derived c1 = new Derived();
        System.out.println(c1);
    }
}
