/**
 * class has method binarySearch function that return index of searched element
 * if element not found then return -1 value
 * @author Manish
 *
 */
public class BinarySearch {
	int index = -1;		//this variable hold index of search element
	int indextemp = -1;	//this variable hold temporary index of element
	
	//method perform binary search operation and return index of search element
	public int binarySearch(int array[] , int element , int lowerBound , int upperBound) {
		
		//check lowerBound is less or equal to upperBound of array
		if(lowerBound<=upperBound) {
			//calculate mid value of array
			int mid = (lowerBound+upperBound)/2;
			//check mid position of array contains element 
			if( array[mid] == element) {
				//hold index of element as mid position
				index = mid;
				//Recursively call binary sort for the left side part of array
				//store the leftmost occurrence of element
				binarySearch(array, element, lowerBound, mid-1);
			}
			//check element greater then mid element of array
			else if( array[mid] < element) {
				//call binary sort for the right side part of array
				binarySearch(array, element, mid+1, upperBound);
			}
			
			else {
					//call binary sort for the left side part of array
					binarySearch(array, element, lowerBound, mid-1);
			}
		}
		return index;
	}
}
