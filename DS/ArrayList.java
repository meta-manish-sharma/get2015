/**
 * This class  ArrayList implement the basic functions of ArrayList class
 * @author Manish
 *
 */
public class ArrayList {
	
	private int size;
	private Object[] elementData; 
	private int capacity;
	
	//default constructor initialize capacity with 10
	public ArrayList() {
		this(10);
	}
	
	//this constructor initialize capacity with passed argument value
	public ArrayList(int capacity) {
		this.capacity=capacity;
		if(capacity>0) {
			elementData = new Object[capacity];
		}
		else {
			 throw new IllegalArgumentException("Illegal Capacity: "+capacity);
		}
	}
	
	//this method add object and if size is full then increase size also
	public void  add(Object item) {
		if(capacity>size) {
			elementData [size++] = item;
		}
		else {
			if(capacity <= size) {
				capacity=capacity+5;
				Object newElementData[] = elementData;
				elementData = new Object[capacity];
				for(int i=0;i<newElementData.length;i++) {
					elementData[i] = newElementData[i];
				}
				elementData[size++]=item;
			}
		}
	}
	
	//this method return size of arrayList
	public int size() {
		return size;
	}
	
	//this method add element to specified index
	public void add(Object item ,int index) {
		if(index < 0 || index>size ) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		}
		else {
				if(capacity <= size) {
					capacity=capacity+5;
				}
				Object newElementData[] = elementData;
				elementData = new Object[capacity];
				for(int i=0;i<index;i++) {
					elementData[i] = newElementData[i];
				}
				elementData[index]=item;
				for(int i = index + 1;i<newElementData.length;i++) {
					elementData[i] = newElementData[i-1];
				}
				size++;
		}
	}
	
	//this method find first occurrence of element after given index  
	public int firstOccurrence(Object item , int index) {
		if(index < 0 || index>size ) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		}
		else {
			int i;
			for( i=index;i<size;i++){
				if(elementData[i].equals(item)) {
					break;
				}
			}
			if(i!=size){
				return i;
			}
			else {
				return -1;
			}
		}
	}
	
	//this method find first occurrence of element
	public int firstOccurrence(Object item) {
		for(int i=0;i<size;i++){
			if(elementData[i].equals(item)) {
				return i;
			}
		}
		
		return -1;
	}
	
	//this method remove element from given index
	public void remove(int index) {
		if(index>=size) {
			throw new ArrayIndexOutOfBoundsException("Illegal Index: " + index);
		}
		else {
			for(int i=index+1;i<size;i++){
				elementData[i-1] = elementData[i];
			}
			size--;
		}	
	}
		
	//this method remove given element from arrayList
	public void remove(Object item) {
		int i;
		for( i=0;i<size;i++){
			if(elementData[i].equals(item)) {
				break;
			}
		}
		if(i==size) {
			throw new NullPointerException("Illegal item: " + item);
		}
		else {
			for(int j=i+1;j<size;j++){
				elementData[j-1] = elementData[j];
			}
			size--;
		}
	}
	
	//this method remove all elements of arrayList
	public void removeAll() {
		if(elementData.length==0){
			throw new NullPointerException("ArrayList is Empty ");
		}
		else {
			elementData = new Object[0];
			size=0;
		}
	}
	
	//this method sort the arrayList
	void sort() {
		Object temp;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if((int)elementData[i]>(int)elementData[j]) {
					temp=elementData[i];
					elementData[i]=elementData[j];
					elementData[j]=temp;
				}
			}
		}
	}
	
	//this method reverse the arrayList
	public void reverse() {
		Object temp[] = new Object[size];
		for(int i=0;i<size;i++) {
			temp[i] = elementData[i];
		}
		
		for(int i=size-1,k=0;i>=0;i--) {
			elementData[k++] = temp[i];
		}
	}
	
	//this method show all elements of arrayList
	public void display(){
		for(int i=0;i<size;i++) {
			System.out.println(elementData[i]);
		}	
	}
	
	//this method copy secondArrayList into firstArrayList
	void copy(ArrayList firstArrayList, ArrayList secondArrayList) {
		Object temp [] = firstArrayList.elementData;
		int newSize = firstArrayList.size()+secondArrayList.size();
		firstArrayList.elementData = new Object[newSize];
		for(int i=0,k=0;i<newSize;i++) {
			if(i<size) {
				firstArrayList.elementData[i] = temp[i];
			}
			else {
				firstArrayList.elementData[i] = secondArrayList.elementData[k++];
			}
		}
		size=newSize;
		
	}
	
}
