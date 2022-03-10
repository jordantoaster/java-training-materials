package generics.reflection;

import java.util.*;

class Employee {
}
class Manager extends Employee {	
}
class Developer extends Employee {
}

public class ProgramOne {
	public static void main(String[] args) {
		//We only want Managers
		List <? extends Employee> results1 = filterList(buildInput(),Manager.class);
		//We only want Developers
		List <? extends Employee> results2 = filterList(buildInput(),Developer.class);
		
		System.out.println("Results 1");
		for(Employee emp : results1) {
			System.out.println(emp);
		}
		System.out.println("Results 2");
		for(Employee emp : results2) {
			System.out.println(emp);
		}
	}
	private static List<Employee> buildInput() {
		List<Employee> myList = new ArrayList<Employee>();
		myList.add(new Employee());
		myList.add(new Manager());
		myList.add(new Developer());
		myList.add(new Employee());
		myList.add(new Manager());
		myList.add(new Developer());
		myList.add(new Employee());
		myList.add(new Manager());
		myList.add(new Developer());
		myList.add(new Employee());
		myList.add(new Manager());
		myList.add(new Developer());
		return myList;
	}
	public static <T> List<? extends T> filterList(List<T> input, Class<? extends T> rtti) {
		List<T> output = new ArrayList<T>();
		for(T obj : input) {
			if(rtti.isInstance(obj)) {
				output.add(rtti.cast(obj));
			}
		}
		return output;
	}

}
