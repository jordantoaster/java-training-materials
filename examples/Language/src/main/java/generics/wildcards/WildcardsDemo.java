package generics.wildcards;

import java.util.ArrayList;

class Employee {
}

class Manager extends Employee {
}

class Director extends Manager {
}

@SuppressWarnings("unused")
public class WildcardsDemo {
    public static void main(String[] args) {
        ArrayList<Employee> list1 = new ArrayList<Employee>();
        ArrayList<Manager> list2 = new ArrayList<Manager>();
        ArrayList<Director> list3 = new ArrayList<Director>();

        func1(list1);
        //func1(list2);  //Will not compile
        //func1(list3);  //Will not compile

        func2(list1);
        func2(list2);
        func2(list3);

        //func3(list1);  //Will not compile
        func3(list2);
        func3(list3);

        func4(list1);
        func4(list2);
        //func4(list3);  //Will not compile

    }

    private static void func1(ArrayList<Employee> param) {
        param.add(new Employee());    //OK
        param.add(new Manager());    //OK
        Object obj = param.get(0);   //OK
        Employee emp = param.get(0); //OK
        //Manager mgr = param.get(0);  //Will not compile
    }

    private static void func2(ArrayList<?> param) {
        //param.add(new Employee());   //Will not compile
        //param.add(new Manager());    //Will not compile
        Object obj = param.get(0);     //OK
        //Employee emp = param.get(0); //Will not compile
        //Manager mgr = param.get(0);  //Will not compile
    }

    private static void func3(ArrayList<? extends Manager> param) {
        //param.add(new Employee());   //Will not compile
        //param.add(new Manager());  //Will not compile
        Object obj = param.get(0);   //OK
        Employee emp = param.get(0); //OK
        Manager mgr = param.get(0);  //OK
    }

    private static void func4(ArrayList<? super Manager> param) {
        //param.add(new Employee());   //Will not compile
        param.add(new Manager());      //OK
        Object obj = param.get(0);     //OK
        //Employee emp = param.get(0); //Will not compile
        //Manager mgr = param.get(0);  //Will not compile
    }
}
