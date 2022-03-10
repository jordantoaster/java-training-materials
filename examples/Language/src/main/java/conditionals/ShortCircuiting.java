package conditionals;

public class ShortCircuiting {
    public static void main(String[] args) {
        int val1 = 12;
        int val2 = 34;

        if (val1 > 10 && ++val2 > 30) {
            System.out.println("AAA");
        }
        System.out.println(val2);

        if (val1 < 10 && ++val2 > 30) {
            System.out.println("BBB");
        }
        System.out.println(val2);

        if (val1 < 10 || ++val2 > 30) {
            System.out.println("CCC");
        }
        System.out.println(val2);

        if (val1 > 10 || ++val2 > 30) {
            System.out.println("DDD");
        }
        System.out.println(val2);
    }
}
