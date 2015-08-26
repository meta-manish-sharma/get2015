/**
 *this class create node for doubly linkedList 
 * @author Manish
 *
 * @param <T>
 */
public class DoublyNode <T> {
	public T nodeValue;
	public DoublyNode <T> pre;
	public DoublyNode <T> next;
	
	public DoublyNode(){
		nodeValue = null;
		pre = null;
		next = null;
	}
	
	public DoublyNode (T item) {
		nodeValue = item;
		pre = null;
		next = null;
	}
}
