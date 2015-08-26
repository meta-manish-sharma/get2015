/**
 * This class implements basic operations of DoublyLinkedList class
 * @author Manish
 *
 */
public class DoubleLinkedList {
	DoublyNode start = null;
	DoublyNode end = null;
	DoublyNode node;
	DoublyNode current = null;
	DoublyNode before = null;
	int counter = 0;
	
	//this method create DoublyLinkedList
	void add(Object item) {
		node = new DoublyNode (item);
		if(start == null) {
			start = node;
			end = node ;
			counter=1;
		}
		else {
			
			
			current =start;
			while(current.next!=null){
				current=current.next;
				
			}
			current.next=node;
			node.pre=current;
			end=node;
			counter++;

		}
	}
	
	
	//this method add item at given position in linked list
		void add(int position, Object item){
			int count=0;
			if(position>counter || position<0) {
				throw new ArrayIndexOutOfBoundsException("Illegal position : " + position);
			}
			else {
					 count=0;
					node = new DoublyNode (item);
					if(position == 1){
						current=start;
						start=node;
						current.pre=node;
						node.next=current;
					}
					else {
							current =start;
							while(current.next!=null){
								if(count==position-2) {
									break;
								}
								current=current.next;
								count++;
							}
							node.next = current.next;
							current.next = node;
							node.pre = current;
							current.next.pre = node;
							//current=node;
							counter++;
					}
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
					current.next.next.pre = current;
		
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
				current.next.next.pre = current;
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
		
		//this method sort the given linkedList
		void sort() {
			if(start==null){
				throw new NullPointerException("Link list is empty");
				}
			else {
					DoublyNode temp,before;
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
		
		void reverse() {
			
			current=start;
			while(current.next!=null){
				before=current.next;
				current.next=current.pre;
				current.pre=before;
				current=before;
				
				}
			
				start=current;
			
		}
		
		//this method display the linkedList
		void display() {
			if(start==null || end == null) {
				throw new NullPointerException("Link list is empty");
			}
			else {
					//before = start;
					current = start;
					while(current!=null) {
						System.out.println(current.nodeValue);
						current=current.next;
					}
			}
		}
}