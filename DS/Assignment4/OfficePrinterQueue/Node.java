package OfficePrinterQueue;
/**
 *  this class stores the information about college department 
 *  and there printing message
 * @author Manish
 */


 
 
public class Node {
	public int priority;
	public String name;
	public String department;
	public String message;
	
	/* default constructor */
	public Node () {
		priority = -1;
		name = "";
		department = "";
		message = "";
	}
	
	/* Initialize attributes of class by argument value */
	public Node(int priority, String name, String department, String message ) {
		this.priority = priority;
		this.name = name;
		this.department = department;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "	"+name+"	"+department+"	"+message;
	}
}
