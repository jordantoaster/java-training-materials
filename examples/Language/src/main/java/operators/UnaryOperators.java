package operators;

public class UnaryOperators {
    public static void main(String[] args) {
        int myvar1 = 16;
        int myvar2 = 23;
        boolean myvar3 = true;

        int result1 = myvar1++;
        int result2 = ++myvar1;
        int result3 = myvar2--;
        int result4 = --myvar2;
        boolean result5 = !myvar3;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}
