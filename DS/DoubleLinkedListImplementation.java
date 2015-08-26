/**
 * This class uses the basic operations of DoublyLinkedList class
 * @author Manish
 *
 */
public class DoubleLinkedListImplementation {

	public static void main(String[] args) {
		DoubleLinkedList dList = new DoubleLinkedList();	//create an array list object
		dList.add(5);										//add element to the single link list
		dList.add(6);
		dList.add(8);
		dList.add(12);
		dList.add(15);
		dList.add(3,9);									//add element in linkedList at given index at first argument
		dList.add(16);
		dList.add(18);
		dList.add(2);
		//dList.reverse();
		System.out.println("Linked List ");
		dList.display();
		dList.remove(3);		//add element in linkedList at given index at first argument
		System.out.println("remove given position 3 element from LinkedList ");
		dList.display();
		dList.remove((Object)6);	 //remove given object from LinkedList
		System.out.println("remove given object (6) from LinkedList");
		System.out.println("Linked List ");
		dList.display();
		Object element = dList.retrievalItem(4);	//Retrieve item at given position
		System.out.println("Retrieve item at given position (2) --->>  "+element);
		dList.sort();			//sort the linkedList
		System.out.println("Sorted linkedList");
		dList.display();
		
	}

}
