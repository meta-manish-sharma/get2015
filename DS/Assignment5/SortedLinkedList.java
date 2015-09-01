import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * this class implement sorted linkedList recursively
 * @author Manish
 *
 */

public class SortedLinkedList {
	
	//create linkedList
	public static LinkedList <Integer> list = new LinkedList<Integer>();   
	int size = 0; 
	
	//method store element at the appropriate position 
	public static void checkIndex(int index, int element)
	{
		if(index==list.size())
		{
			list.add(element);
		}
		else if(((int)list.get(index) < element)&&((index+1)<=list.size())) {
			checkIndex(index+1, element);
		}	
		else {
			list.add(index, element);
		}	
	}
	
	//main method
	public static void main(String[] args) { 
		
		LinkedList<Integer> integersStr=new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		String choice;
		int index=0;
		int data;
		while(true) {
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to remove data");
			System.out.println("Enter 3 to display data");
			System.out.println("Enter 4 to exit");
			choice = scan.next();
			switch(choice) {
			case "1" : System.out.println("Enter data to insert");
						data = scan.nextInt();
						checkIndex(index, data);
						break;
			case "2" : System.out.println("removed data = "+list.remove());
					   break;
			case "3" : System.out.println("\n"+list);
					   break;
			case "4" : return;
			default : System.out.println("Enter correct choice");
			}
			
		}
	}
}
