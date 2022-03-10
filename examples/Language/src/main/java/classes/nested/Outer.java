package classes.nested;

public class Outer {
    private void methodA() {
        System.out.println("Outer.methodA");
    }

    private void methodB() {
        System.out.println("Outer.methodB");
    }

    private static void methodC() {
        System.out.println("Outer.methodC");
    }

    public class InnerOne {
        InnerOne() {
            methodA();
            methodB();
            this.methodB();
            Outer.this.methodB();
        }

        private void methodB() {
            System.out.println("InnerOne.methodB");
        }
        //Will not compile unless final
        //static double MAGIC = 22222;
    }

    public static class InnerTwo {
        static double MAGIC = 22222;

        InnerTwo() {
            //methodB(); //will not compile
            methodC();
        }
    }
}
