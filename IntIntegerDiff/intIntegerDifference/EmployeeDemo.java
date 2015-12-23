package intIntegerDifference

/**
 * @author Manish
 * Class demonstrating difference between Integer and int.
 * 1. Integer have default value null whereas int have default value 0.
 * 2. For storing number in collection, Integer is used. int is not supported by collection for storing number. 
 * 3. Integer is a wrapper class, where as int is a primitive data type.
 */
public class EmployeeDemo {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("firstname");
		System.out.println("employee information before function : " + employee);
		updateEmployee(employee);
		System.out.println("employee information after function : " + employee);
		
		Integer i = 4;
		i=6;
		System.out.println("i in main before updateInteger : "+i);
		updateInteger(i);
		System.out.println("i in main after updateInteger : "+i);
	}

	public static void updateEmployee(Employee employee) {
		employee.setName("firstname lastname");
	}
	
	public static void updateInteger(Integer j) {
		System.out.println("j in function before update : "+j);
		j= 5;
		System.out.println("j in function after update : "+j);
	}
}
