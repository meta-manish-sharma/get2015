package InfixToPostfix;
/**
 * this class implements stack basic functions using linkedlist
 * @author Manish
 *
 */

public class Stack {

	LinkedList list= new LinkedList();
	int top=0;
	
	//this operation add an element to the stack
	void push(Object item){
		list.add(item);
		top++;
	}
	
	//this operation remove and return top element of the stack
	Object pop () {
		if(top<=0){
			throw new NullPointerException("Illeagal value : " + top);
		}
		Object object = list.retrievalItem(top);
		list.remove(top);
		top--;
		return object;
	}
	
	//this operation return true if stack is empty
	boolean isEmpty() {
		if(top <= 0){
			return true;
		}
		return false;
	}
}
