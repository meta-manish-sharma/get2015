package CustomException;

import java.util.Scanner;

public class DemoCalculator {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		int result;
		System.out.println("Enter first number");
		int no1 = scanner.nextInt();
		System.out.println("Enter second number");
		int no2 = scanner.nextInt();
		
		result = calculator.sum(no1, no2);
		System.out.println("Addition is = "+result);
		result = 0;
		try {
			
			result = calculator.division(no1, no2);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		System.out.println("division is = "+result);
		scanner.close();
	}

}
