package operators;

public class TernaryConditional {
    public static void main(String[] args) {
        int myvar1 = 23;
        int myvar2 = 32;

        int result1 = (myvar1 < myvar2) ? 101 : 202;
        int result2 = (myvar2 - myvar1 == 8) ? 1001 : 2002;

        System.out.println(result1);
        System.out.println(result2);
    }
}
