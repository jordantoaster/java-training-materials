package classes.inheritance;

public class Employee extends Object {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
    	this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return getClass().getName() + " called " + name
        		+ " of age " + age + " earning " + salary;
    }
    public void awardBonus(double bonus) {
        salary += bonus;
    }
    public void awardBonus() {
        awardBonus(500);
    }
}
