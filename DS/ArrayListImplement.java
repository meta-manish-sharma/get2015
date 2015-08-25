/**
 * This class implements all the methods of class arrayList
 * @author Manish
 *
 */
public class ArrayListImplement {

	public static void main(String[] args) {
		ArrayList arrayListOne = new ArrayList();			//arrayList First
		ArrayList arrayListTwo = new ArrayList();			//arrayList Second
		arrayListOne.add(1);							//add element in arrayList	
		arrayListOne.add(12);
		arrayListOne.add(2);
		arrayListOne.add(1);
		arrayListTwo.add("abc");
		arrayListOne.add(3);
		arrayListOne.add(2);
		arrayListTwo.add("acx");
		arrayListOne.add(4);
		arrayListOne.add(5);
		arrayListTwo.add("a");
		arrayListOne.add(6);
		arrayListOne.add(10,2);				//add element in arrayList by position
		System.out.println("	First array List");
		arrayListOne.display();				//display arrayList First
		System.out.println();
		System.out.println("	Second array List");
		arrayListTwo.display();				//display arrayList Second
		System.out.println();
		//call method firstOccurrence by item
		System.out.println("Data at position = " + arrayListOne.firstOccurrence(2)); 
		System.out.println();
		//call method firstOccurrence by item after index 3 
		System.out.println("Data at position after index (3) = " + arrayListOne.firstOccurrence((Object)1,3)); 
		System.out.println("remove element at index 3");
		arrayListOne.remove(3); //remove element at index 3
		arrayListOne.display();	
		System.out.println("remove object 1 from firstOccurrence");
		arrayListOne.remove((Object)1); //remove object 1 from firstOccurrence
		arrayListOne.display();	
		arrayListOne.sort();		//Sort the array list one
		System.out.println("Sort the array list one");
		arrayListOne.display();
		arrayListOne.reverse();   //reverse the array List one
		System.out.println("reverse the array List one");
		arrayListOne.display();
		System.out.println("Copy array List one and two into array List one");
		//al.removeAll();
		//System.out.println(al.firstOccurrence(023));
		arrayListOne.copy(arrayListOne,arrayListTwo);
		arrayListOne.display();
		System.out.println("Remove all elements");
		arrayListOne.removeAll();
		arrayListOne.display();
	}

}
