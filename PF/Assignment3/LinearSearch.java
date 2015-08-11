/**
 * Linear search using recursion 
 * @author Manish
 *
 */
public class LinearSearch {
	
	//this method find the element recursively
	int search(int [] array,int position,int searchElement){
		
		//here we check at every position and if element not find then call for next position
		if((position<array.length) && (array[position]!=searchElement)){
			return search(array,++position,searchElement);
		}
		else{
			
			//here we check element is find at position nd print the position
			if((position<array.length) && (array[position]==searchElement)){
				System.out.print("Element Found at the position ");
				return position+1;	
			}	
			else
				return -1;
		}
	}
	
	public static void main(String[] args) {
		LinearSearch object=new LinearSearch();
		int array[]= {2,5,8,9,10, 77, 55};
		int remainder=object.search(array,0,55);
		System.out.println(remainder);

	}

}
