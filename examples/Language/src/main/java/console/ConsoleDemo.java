package console;

import java.io.Console;

public class ConsoleDemo {
	public static void main(String[] args) {
		Console console = System.console();
		
		console.printf("Enter a username\n");
		String userName = console.readLine();
		
		while(true) {
			String password = console.readLine("Enter a password %s\n", userName);	
			char [] passwordCheck = console.readPassword("Please re-enter your password %s\n", userName);
			
			if(password.equals(new String(passwordCheck))) {		
				console.printf("Account created for %s with password %s\n", userName, password);
				break;
			} else {
				console.printf("Passwords do not match - please try again...\n");
			}
		}
	}
}
