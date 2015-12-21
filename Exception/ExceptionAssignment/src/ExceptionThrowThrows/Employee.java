package ExceptionThrowThrows;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee {

	public static void exceptionHandling() throws FileNotFoundException {
		String name;
		int id = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name");
		name = scanner.nextLine();
		try {
			id = Integer.parseInt(name);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			scanner.close();
			throw new FileNotFoundException("Throw File Not Found Exception Object ");
		}
		System.out.println(id);
		scanner.close();

	}
	
	public static void main(String[] args) {
		try {
			exceptionHandling();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
