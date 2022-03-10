package boxing;

import java.util.Date;

public class IntroducingBoxing {
	public static void main(String[] args) {
		Object [] stuff = new Object[6];
		stuff[0] = "ABC";
		stuff[1] = new Date();
		stuff[2] = 123;
		stuff[3] = 45.6;
		stuff[4] = 'c';
		stuff[5] = true;
		
		System.out.println("Types  and values of objects in array are:");
		for(Object obj : stuff) {
			System.out.printf("\t %s (%s)\n", obj, obj.getClass().getName());
		}
	}
}
