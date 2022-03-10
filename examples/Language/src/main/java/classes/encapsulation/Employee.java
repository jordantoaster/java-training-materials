package classes.encapsulation;

public class Employee {
    //fields
    private String name;
    private int age;
    private double salary;

    //this is a constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //this is an example of overriding
    public String toString() {
        return getClass().getName() + " called " + name
                + " of age " + age + " earning " + salary;
    }

    //the 'awardBonus' method is overloaded
    public void awardBonus(double bonus) {
        salary += bonus;
    }

    public void awardBonus() {
        awardBonus(500);
    }
}
