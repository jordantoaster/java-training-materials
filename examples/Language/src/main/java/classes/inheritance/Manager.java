package classes.inheritance;

public class Manager extends Employee {
    private String department;
    private double budget;

    public Manager(String name, int age, double salary, 
            		String department, double budget) {
        super(name, age, salary);
        this.department = department;
        this.budget = budget;
    }
    public String toString() {
        String msg = super.toString();
        return msg + " managing " + department + " with budget " + budget;
    }
    public void awardBonus(double bonus) {
        super.awardBonus(bonus * 2);
    }
    public void raiseBudget(double raise) {
        budget += raise;
    }
}
