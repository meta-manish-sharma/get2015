package BST;

/**
 *this class create node for binary Tree 
 * @author Manish
 *
 * @param <T>
 */
public class Node <T> {
	public T data;
	public Node <T> left;
	public Node <T> right;
	
	public Node(){
		data = null;
		left = null;
		right = null;
	}
	
	public Node (T item) {
		data = item;
		left = null;
		right = null;
	}
}
