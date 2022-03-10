package generics.in.depth;

import java.util.LinkedList;

class Employee {}
class Manager extends Employee {}
class Director extends Manager {}

public class Program {

    //Using concrete types to focus on Generics
    static LinkedList<Employee> empList = new LinkedList<>();
    static LinkedList<Manager> mgrList = new LinkedList<>();
    static LinkedList<Director> dirList = new LinkedList<>();

    public static void main(String[] args) {
//        regularMethod(empList); //A
//        regularMethod(mgrList); //B
//        regularMethod(dirList); //C

//        methodWithWildcard(empList); //A
//        methodWithWildcard(mgrList); //B
//        methodWithWildcard(dirList); //C

//        methodWithUpperBound(empList); //A
//        methodWithUpperBound(mgrList); //B
//        methodWithUpperBound(dirList); //C

//        methodWithLowerBound(empList); //A
//        methodWithLowerBound(mgrList); //B
//        methodWithLowerBound(dirList); //C
    }

    private static void regularMethod(LinkedList<Employee> input) {
//        input.add(new Employee()); //A
//        input.add(new Manager());  //B
//        input.add(new Director()); //C
    }

    private static void methodWithWildcard(LinkedList<?> input) {
//        input.add(new Employee()); //A
//        input.add(new Manager());  //B
//        input.add(new Director()); //C
//        input.add(new Object());   //D
    }

    private static void methodWithUpperBound(LinkedList<? extends Manager> input) {
//        input.add(new Employee()); //A
//        input.add(new Manager());  //B
//        input.add(new Director()); //C
    }

    private static void methodWithLowerBound(LinkedList<? super Manager> input) {
//        input.add(new Employee()); //A
//        input.add(new Manager());  //B
//        input.add(new Director()); //C
    }
}
