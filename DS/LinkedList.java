/**
 * This class implements basic operations of LinkedList class
 * @author Manish
 *
 */
public class LinkedList {
	Node start = null;
	Node node;
	Node current = null;
	int counter=0;
	
	//this method add item into the linked list
	void add(Object item) {
		node = new Node (item);
		if(start==null) {
			start=node;
			counter=1;
		}
		else {
				current =start;
				while(current.next!=null){
					current=current.next;
				}
				current.next=node;
				counter++;
		}
	}
	
	//this method add item at given position in linked list
	void add(int position, Object item){
		if(position>counter || position<0) {
			throw new ArrayIndexOutOfBoundsException("Illegal position : " + position);
		}
		else {
				int count=0;
				node = new Node (item);
				current =start;
				while(current.next!=null){
					if(count==position-2) {
						break;
					}
					current=current.next;
					count++;
				}
				node.next=current.next;
				current.next=node;
				//current=node;
				counter++;
		}
	}
	
	//This method remove element from given position from linked list
	void remove(int position) {
		if(position>counter || position<=0) {
			throw new ArrayIndexOutOfBoundsException("Illegal position : " + position);
		}
		else if(position == 1) {
			start=start.next;
		}
		else{
				int count=2;
				//node = new Node (item);
				current =start;
				while(current.next!=null){
					
					if(count==position) {
						//nextElement=current.next;
						break;
					}
					current=current.next;
					count++;
				}
				current.next=current.next.next;
	
				counter--;
		}
	}
	
	//this method remove given item from linkedList
	public void remove(Object item) {
		
		if(start==null){
			throw new NullPointerException("Link list is empty");
			}
		else if(start.nodeValue.equals(item)){
			
			start=start.next;
		}
		else{
			current=start;
			while(current.next!=null){
				if(current.next.nodeValue.equals(item)){
					//System.out.println("		"+current.nodeValue);
					break;	
				}	
				current=current.next;
			}
			current.next=current.next.next;
			counter--;
			
		}	
	}
	
	//this method return the element at given position
	public Object retrievalItem(int position) {
		if(position>counter || position<=0) {
			throw new ArrayIndexOutOfBoundsException("Illegal position : " + position);
		}
		else if(position == 1) {
			return start.nodeValue;
		}
		else{
				int count=2;
				
				current =start;
				while(current.next!=null){
					
					if(count==position) {
						
						break;
					}
					current=current.next;
					count++;
				}
				return current.next.nodeValue;
	
				
		}
	}
	
	//this method reverse the linkedList
	void reverse(){
		int i=0;
		Node previous=null;
		if(start==null){
			throw new NullPointerException("Link list is empty");
			}
		else {
			 	Node before = null; 
			 	current = start;
			 	Node next = current.next;
    			while(current.next != null) {
        			current.next = before;
        			before = current;
        			current = next;
        			next = current.next;
    			}
    			current.next = before;
    			start = current;
		}
		
	}
	
	//this method sort the given linkedList
	void sort() {
		if(start==null){
			throw new NullPointerException("Link list is empty");
			}
		else {
				Node temp,before;
				temp=start.next;
				while(temp!=null){
					before=start;
					current=start.next;
					while(current!=null) {
						if((int)current.nodeValue<=(int)before.nodeValue) {
							Object o = current.nodeValue;
							current.nodeValue=before.nodeValue;
							before.nodeValue=o;
						}
						before=current;
						current=current.next;
					}	
					temp=temp.next;	
				}
		}
	}
	
	//this method display the linkedList
	void display() {
		if(start==null) {
			throw new NullPointerException("Link list is empty");
		}
		else {
				current = start;
				do{
					System.out.println(current.nodeValue);
					current=current.next;
				}while(current!=null);
		}
	}
}
