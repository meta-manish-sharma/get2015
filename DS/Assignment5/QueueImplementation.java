import java.util.Scanner;
/**
 * class uses the methods of queue
 * @author Manish
 *
 */

public class QueueImplementation {

	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		
		//create object of queue class
		Queue queue = new Queue();
		String choice;
		String element;
		
		while (true) {
			System.out.println("Enter 1 for enqueue ");
			System.out.println("Enter 2 for dequeue ");
			System.out.println("Enter 3 for exit ");
			choice = scan.nextLine();
			
			switch(choice) {	
			case "1" : System.out.println("Enter element ");
					   element = scan.nextLine();
					   queue.enqueue(element);		//call enqueue method of queue class
					   break;
			
			case "2" : System.out.println("dequeue element : "+queue.dequeue());		//call dequeue method of queue class   
						break;
			
			case "3" : return;
			
			default : System.out.println("Please enter vaild input ");
			
			}
		}
	}
	
}
