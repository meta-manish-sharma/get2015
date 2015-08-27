package CollegeCounselingSystem;
/**
 * this class implements Queue basic functions using ArrayList
 * @author Manish
 *
 */

public class Queue {
	
	Object list[];
	int front = -1;		//hold the location in queue where dequeue possible
	int rear = -1;		//hold the location in queue where enqueue possible
	public Queue(int n) {
		list = new Object[n];
		
	}
	
	//add object to queue at front
	void enQueue (Object item ) {
		if(rear==-1) {		//check list is empty
			rear = 0;
			front = 0;
			list[rear] = item;	
		}
		else {
			list[++rear] = item;
		}
	}
	
	//remove object from rear of queue and return object
	Object deQueue() {
		Object object;
		if(front==rear+1 || front == -1) {		//check queue is empty
			throw new NullPointerException("Queue is empty");
		}
		else {
				object = list[front];
				front++;				
		}
		return object;
	}
	
	//Remove all items of queue and make queue empty
	void makeEmpty( ) {
		rear = -1;
		front = -1;
	}
}
