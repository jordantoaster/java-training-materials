package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
	ListingMembers is a class that is very interested in its own structure.
	In the main method we use the Class object associated with the Narcissistic
	 class to print the members of the object (name and type) and the methods
	 (name and return type).
*/
public class ListingMembers {
    public static void main(String[] args) {
        System.out.println("My methods are:");
        printMethods();
        System.out.println("My fields are:");
        printFields();
    }

    public static void printFields() {
        Field[] fields = ListingMembers.class.getDeclaredFields();
        for (Field f : fields) {
            String msg = "\t" + f.getName() + " of type " + f.getType();
            System.out.println(msg);
        }
    }

    public static void printMethods() {
        Method[] methods = ListingMembers.class.getDeclaredMethods();
        for (Method m : methods) {
            String msg = "\t" + m.getName() + " returning " + m.getReturnType();
            System.out.println(msg);
        }
    }
}
