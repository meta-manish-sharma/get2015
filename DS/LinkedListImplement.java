/**
 * This class uses the basic operations of LinkedList class
 * @author Manish
 *
 */
public class LinkedListImplement {
	public static void  main(String args[]) {
		LinkedList list= new LinkedList(); //create an array list object
		list.add(12);						//add element to the single link list
		list.add(11);
		list.add(13);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6,10);					//add element in linkedList at given index at first argument
		System.out.println("Linked List ");
		list.display();
		list.remove((Object)7); //remove given object from LinkedList
		System.out.println("remove given object (7) from LinkedList");
		list.display();
		list.remove(3);			//remove element from given position
		System.out.println("remove element from given position (3)");
		list.display();
		Object element = list.retrievalItem(2);	//Retrieve item at given position
		System.out.println("Retrieve item at given position (2) --->>  "+element);
		
		list.sort();			//sort the linkedList
		System.out.println("Sorted linkedList");
		list.display();
		list.reverse();      //reverse the linked list
		System.out.println("Reversed linkedList");
		list.display();
	}

}
