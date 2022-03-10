package classes.anonymous;

public class Outer {

    public static void main(String[] args) {
        Outer demo = new Outer(22);
        System.out.println(demo.anonOne);
        System.out.println(demo.anonTwo);

        final double d = 12.3;
        Object anonThree = new Object() {
            public String toString() {
                return "Value of d is: " + d;
            }
        };
        System.out.println(anonThree);
    }

    Outer(int val) {
        i = val;
        anonTwo = new Object() {
            {
                i += 10;
            }

            public String toString() {
                return "Value of i is: " + i;
            }
        };
    }

    private Object anonOne = new Object() {
        public String toString() {
            return "Value of i is: " + i;
        }
    };
    private Object anonTwo;
    private int i;
}
