
public class NewBinarySearch {
	
	int index = -1;		//index variable hold index of search element
	
	public int binarySearch(int array[] , int element , int lowerBound , int upperBound) {
		
		while(lowerBound<=upperBound) {
			//terminate loop when leftBound become greater then upperBound
			int mid = (lowerBound+upperBound)/2;
			if( array[mid] == element) {
				//if element found at mid position then store mid value in index
				index = mid;
				//continue loop for the left side part of array
				//upperBound = mid - 1;	//for leftmost element
				//continue loop for the right side part of array
				lowerBound = mid + 1;	//for rightmost element 
				continue;
			}	
			else if( array[mid] < element) {
				//continue loop for the right side part of array
				lowerBound = mid + 1;
				continue;
			}	
			else {
					//continue loop for the left side part of array
					upperBound = mid - 1;
			}
		}
		//return the index value of element if element not found then return -1
		return index;
	}

}
