package ParameterizedConstructor;

/**
 * @author Manish
 * DemoEmployee class demonstrating parameterized constructors
 */
public class DemoEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Employee employee = new Employee("Anjita", 1);
		System.out.println(employee);
		
		Employee employee2 = new Employee("Chetna", 2, "jaipur");
		System.out.println(employee2);
		
		Employee employee3 = new Employee("Manish", 3, "jaipur", "Java");
		System.out.println(employee3);
	}

}
