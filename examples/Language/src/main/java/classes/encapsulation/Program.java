package classes.encapsulation;

public class Program {
    public static void main(String[] args) {
        Employee e1 = new Employee("Joe Bloggs", 27, 30000);
        Employee e2 = new Employee("Jane Smith", 29, 40000);

        System.out.println("---- Initial object state ----");
        System.out.println("\t" + e1);
        System.out.println("\t" + e2);

        e1.awardBonus(250);
        e2.awardBonus(750);

        System.out.println("---- After first price raise ----");
        System.out.println("\t" + e1);
        System.out.println("\t" + e2);

        e1.awardBonus();
        e2.awardBonus();

        System.out.println("---- After second price raise ----");
        System.out.println("\t" + e1);
        System.out.println("\t" + e2);
    }
}
