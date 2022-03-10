package exceptions;

import java.io.IOException;

public class FinallyBlocks {
	public static void main(String[] args) throws IOException {
		System.out.println("----- func(1) -----");
		func(1);
		System.out.println("----- func(2) -----");
		func(2);
		System.out.println("----- func(3) -----");
		func(3);
	}
	private static void func(int i) throws IOException {
		try {
			switch(i) {
			case 1:
				System.out.println("Case 1 block");
				break;
			case 2:
				throw new IllegalArgumentException();
			case 3:
				throw new IOException();
			}
		} catch(RuntimeException ex) {
			System.out.println("Catch block");
		} finally {
			System.out.println("Finally block");
		}
	}

}
