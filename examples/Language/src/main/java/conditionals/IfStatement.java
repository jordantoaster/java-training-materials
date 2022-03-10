package conditionals;

public class IfStatement {

    public static void main(String[] args) {
        double value = Math.random();
        System.out.printf("Value is: %.3f\n", value);
        if (value < 0.25) {
            System.out.println("Less than .25");
        } else if (value < 0.5) {
            System.out.println("Less than .5");
        } else if (value < 0.75) {
            System.out.println("Less than .75");
        } else {
            System.out.println("Less than 1");
        }
    }
}
