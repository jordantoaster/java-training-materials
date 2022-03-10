package demos.cucumber.math;

public class SimpleMath {
    private int no1;
    private int no2;

    public SimpleMath(int no1, int no2) {
        this.no1 = no1;
        this.no2 = no2;
    }
    public int add() {
        return no1 + no2;
    }
    public int subtract() {
        return no1 - no2;
    }
    public int multiply() {
        return no1 * no2;
    }

}
