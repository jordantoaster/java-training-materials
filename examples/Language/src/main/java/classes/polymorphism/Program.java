package classes.polymorphism;

import java.util.Arrays;

class Employee {
	public void downsize() {
		System.out.println("An employee has been fired");
	}
}

class Manager extends Employee {
	public void downsize() {
		System.out.println("A manager has been fired");
	}
}

class Consultant extends Employee {
	public void downsize() {
		System.out.println("A consultant has been fired");
	}
}

class SalesPerson extends Employee {
	public void downsize() {
		System.out.println("A salesman has been fired");
	}
}

public class Program {
	public static void main(String[] args) {

		Employee e1 = new Employee();
		Employee e2 = new Manager();
		Employee e3 = new SalesPerson();
		Employee e4 = new Consultant();

		Employee[] people = {e1,e2,e3,e4};
		fireAllEmployees(people);
	}

	private static void fireAllEmployees(Employee[] employees) {
		for (Employee employee : employees) {
			employee.downsize();
		}
		System.out.println("-----------");
		Arrays.stream(employees)
				.forEach(Employee::downsize);
	}
}
