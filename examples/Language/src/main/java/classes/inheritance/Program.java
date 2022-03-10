package classes.inheritance;

public class Program {

    public static void main(String[] args) {
        Employee e = new Employee("Joe Bloggs", 27, 30000);
        Manager m = new Manager("Jane Smith", 46, 10000, "IT", 250000);
        m.raiseBudget(10000);
        System.out.println(e);
        e.awardBonus(500);
        System.out.println(e);

        Employee e2 = m;
        System.out.println(e2);
        e2.awardBonus(500);
        System.out.println(e2);
    }

}