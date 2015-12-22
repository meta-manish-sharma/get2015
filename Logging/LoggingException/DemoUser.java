package LoggingException;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author Manish
 * DemoUser class demonstrating logging function.
 */
public class DemoUser {

	private static Scanner scanner = new Scanner(System.in);
	
	private static Logger logger = Logger.getLogger(DemoUser.class);

	public static void main(String[] args) {
		
		User user[] = new User[2];

		try {
			for (int i = 0; i < 3; i++) {
				user[i] = new User();
				
				System.out.println("Enter user " + (i + 1) + "'s id");
				try {
					user[i].setId(Integer.parseInt(scanner.next()));
				} catch (Exception e) {
					logger.error("Exception occured", e);
				}
				
				System.out.println("Enter user " + (i + 1) + "'s name");
				try {
					user[i].setName(scanner.next());
				} catch (Exception e) {
					logger.error("Exception occured", e);
				}
				
				System.out.println("Enter user " + (i + 1) + "'s address");
				try {
					user[i].setAddress(scanner.next());
				} catch (Exception e) {
					logger.error("Exception occured", e);
				}
				
				System.out.println("Enter user " + (i + 1) + "'s salary");
				try {
					user[i].setSalary(Integer.parseInt(scanner.next()));
				} catch (Exception e) {
					logger.error("Exception occured", e);
				}
			}
		} catch (Exception e) {
			logger.error("Exception occured : Array Index out of bound", e);
		}

		try {
			for (int i = 0; i < 2; i++) {
				System.out.println("User " + i + "'s information: " + user[i]);
			}
		} catch (Exception e) {
			logger.error("Exception occured : Array Index out of bound", e);
		}
		scanner.close();
	}

}
