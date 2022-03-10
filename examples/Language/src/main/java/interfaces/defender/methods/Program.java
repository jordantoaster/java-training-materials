package interfaces.defender.methods;

public class Program {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(12, 34));
        System.out.println(calc.subtract(12, 34));
        System.out.println(calc.multiply(12, 34));
        System.out.println(calc.divide(12, 34));
    }
}
