package boxing;

import java.util.ArrayList;
import java.util.List;

public class BoxingInDepth {

	public static void main(String[] args) {
		demoBoxingAndUnboxing();
		demoBoxingAndCollections();
		demoToStringHack();
		demoBoxingOptimization();
	}

	private static void demoBoxingOptimization() {
		Integer obj2 = 12;
		Integer obj3 = 12;
		if(obj2 == obj3) {
			System.out.println("Boxing optimized");
		} else {
			System.out.println("Boxing not optimized");
		}
	}

	private static void demoToStringHack() {
		String str1 = ((Object)7).toString();
		System.out.println(str1);
	}

	private static void demoBoxingAndCollections() {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(101);
		myList.add(202);
		myList.add(303);
		myList.add(404);
		System.out.println("List contents:");
		for(int i : myList) {
			System.out.print("\t");
			System.out.println(i);
		}
	}

	private static void demoBoxingAndUnboxing() {
		//an example of boxing
		Integer obj1 = 7;
		System.out.println(obj1);
		//an example of unboxing
		int int1 = obj1;
		System.out.println(int1);
	}

}
