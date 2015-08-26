package InfixToPostfix;
/**
 *this class create node for single linkedList 
 * @author Manish
 *
 * @param <T>
 */
public class Node <T> {
	public T nodeValue;
	public Node <T> next;
	
	public Node(){
		nodeValue = null;
		next = null;
	}
	
	public Node (T item) {
		nodeValue = item;
		next = null;
	}
}
