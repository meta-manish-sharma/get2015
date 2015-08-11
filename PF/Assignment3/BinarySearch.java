/**
 * Binary search using recursion 
 * @author Manish
 *
 */
public class BinarySearch {
	
	//this method search element recursively
	int search(int [] array,int lowerBound,int upperBound,int searchElement){
		
		int mid=(lowerBound+upperBound)/2;
		
		//there check whether array[mid] equals search element
		if((mid<array.length) && array[mid]==searchElement){
			System.out.print("Element Found at the position ");
			return mid+1;
		}
		
		//there check whether array[mid] less than search element
		else if((mid<array.length) && array[mid]<searchElement){
				//call the search method from mid+1 to upper bound
			 	return search(array,mid+1,upperBound,searchElement);
		}
		//there check whether array[mid] greater than search element
		else if((mid<array.length) && array[mid]>searchElement){
			//call the search method from upper bound to mid
		 	return search(array,lowerBound,mid-1,searchElement);
		}
		else
				return -1;
}
	
	public static void main(String[] args) {
		BinarySearch object=new BinarySearch();
		int array[]= {2,5,8,9,10, 77, 55};
		int position=object.search(array,0,array.length,99);
		System.out.println(position);

	}

}
