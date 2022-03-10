package classes.downcasting;

class Employee {

}

class Manager extends Employee {

}

class Director extends Manager {

}

public class Program {
	public static void main(String [] args) {
		Employee e1 = new Employee();
		Employee e2 = new Manager();
		Employee e3 = new Director();
		
		if(e1 instanceof Manager) {
			System.out.println("e1 is a kind of Manager");
		} else {
			System.out.println("e1 is NOT a kind of Manager");
		}
		
		if(e2 instanceof Manager) {
			System.out.println("e2 is a kind of Manager");
		} else {
			System.out.println("e2 is NOT a kind of Manager");
		}
		
		if(e3 instanceof Manager) {
			System.out.println("e3 is a kind of Manager");
		} else {
			System.out.println("e3 is NOT a kind of Manager");
		}
	}
}
