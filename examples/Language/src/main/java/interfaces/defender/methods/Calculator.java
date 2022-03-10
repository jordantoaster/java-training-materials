package interfaces.defender.methods;

public class Calculator implements Arithmetic {
    @Override
    public double divide(int no1, int no2) {
        return ((double) no1) / no2;
    }

    @Override
    public int subtract(int no1, int no2) {
        return 1234;
    }
}
