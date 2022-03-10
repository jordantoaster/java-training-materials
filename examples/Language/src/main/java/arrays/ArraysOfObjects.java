package arrays;

import java.util.Arrays;

public class ArraysOfObjects {
    private static class Employee {
        private String name;
        private int age;
        private double salary;

        Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            final String msg = "%s aged %d earning %.2f";
            return String.format(msg, name, age , salary);
        }

        void awardBonus(double bonus) {
            salary += bonus;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = createArrayOfEmployee();
        printArrayOfEmployee(employees);
        raiseMorale(employees);
        printArrayOfEmployee(employees);
    }

    private static Employee[] createArrayOfEmployee() {
        return new Employee[] {
                new Employee("Joe", 40, 15000),
                new Employee("Fred", 35, 20000),
                new Employee("Dave", 18, 25000),
                new Employee("Gordon", 26, 30000),
                new Employee("Simon", 54, 19000)
        };
    }

    private static void raiseMorale(Employee[] input) {
        System.out.println("\n--- Awarding Bonuses ---\n");
        for (Employee employee : input) {
            employee.awardBonus(500);
        }
    }

    private static void printArrayOfEmployee(Employee[] input) {
        System.out.println("All employees are:");
        Arrays.stream(input)
                .map(emp -> "\t" + emp)
                .forEach(System.out::println);
    }
}

