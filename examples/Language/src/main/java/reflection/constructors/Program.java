package reflection.constructors;

import reflection.invocations.TestClass;

import java.lang.reflect.Constructor;

public class Program {
	public static void main(String[] args) throws Exception {
		Class<?> klass = TestClass.class;
		Constructor<?> [] list = klass.getConstructors();
		System.out.printf("Class %s has %d constructors\n", klass.getName(), list.length);
		
		Constructor<?> c1 = klass.getConstructor();
		Constructor<?> c2 = klass.getConstructor(String.class);
		Constructor<?> c3 = klass.getConstructor(String.class, StringBuffer.class);
		
		Object obj1 = c1.newInstance();
		Object obj2 = c2.newInstance("abc");
		Object obj3 = c3.newInstance("def", new StringBuffer("ghi"));
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
	}

}
