package generics.reflection;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.List;

class Test {
	public <T extends Serializable & Cloneable, U> List<T> func(T p1, U p2) {
		return new LinkedList<T>();
	}
}

public class ProgramTwo {
	public static void main(String[] args) {
		Class<Test> klass = Test.class;
		for(Method m : klass.getMethods()) {
			TypeVariable<Method> [] types = m.getTypeParameters();
			if(types.length > 0) {
				System.out.println("Found " + m.toGenericString());
				for(TypeVariable<Method> tv : types) {
					System.out.print("\t With type parameter " + tv.toString());
					Type [] bounds = tv.getBounds();
					if(bounds.length > 0) {
						System.out.print(" and bounds ");
						for(Type t : bounds) {
							System.out.print(t);
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}
	}
}
