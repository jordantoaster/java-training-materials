package roman.numerals;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the number (non number to end)");
			if (input.hasNextInt()) {
				int val = input.nextInt();
				String result = Numeral.convert(val);
				System.out.println(result);
			} else {
				System.out.print("Byeee...");
				break;
			}
		}
	}

}
