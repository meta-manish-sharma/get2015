import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * This class show the sorting of Employee class objects
 * by their name and empId
 * @author Manish
 *
 */

public class EmployeeImplement {
	public static Set<Employee> employee =  new HashSet<Employee>() ; 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String empId="100";
		String name;
		String address;
		String choice;
		while(true) {
			System.out.println("Enter 1 to add employee");
			System.out.println("Enter 2 to show sorted employee list according their empId");
			System.out.println("Enter 3 to show sorted employee list according their name");
			System.out.println("Enter 4 to exit");
			choice = scan.nextLine();
			switch(choice) {
			
				case "1" : System.out.println("Employee name");
							name = scan.nextLine();
							address = scan.nextLine();
							int temp = Integer.parseInt(empId);
							temp++;
							empId = ""+temp;
							Employee emp = new Employee(empId,name,address);
							employee.add(emp);
							break;
							
				case "2" : System.out.println("-----------Sorted employee by empId-----------\n");
					    LinkedList list = new LinkedList(employee);
				            Collections.sort(list,new NameComparator());
						   for(Object e : employee){
							   System.out.println(e.toString());
						   }
						   break;
						   
				case "3" : LinkedList list = new LinkedList(employee);
						   Collections.sort(list,new NameComparator());
						   System.out.println("-----------Sorted employee by Name-----------\n"+list);
						   for(Object e : list){
							   System.out.println(e.toString());
						   }
						   break;
						   
				case "4" : return;
				
				default : System.out.println("please enter right choice");
			}	
		}
	}
}
