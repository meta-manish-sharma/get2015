import java.util.LinkedList;
/**
 * class implements basic methods of queue
 * @author Manish
 *
 */

public class Queue {

	LinkedList<Object> queue = new LinkedList<Object>(); 
	
	//this method return true and add element to rear position in the queue
	public boolean enqueue(Object element){
		queue.addLast(element);	
		return true;
	}
	
	//this method return and remove element from front position in the queue
	public Object dequeue() {
		if(queue.size()>0){	
			Object element = queue.removeFirst(); 	
			return element;
		}
		else {
				//throw underflow exception 
				throw new ArrayIndexOutOfBoundsException("Illeagal front : queue is empty");
		}
	}
}
