/**
 * Quick sort using recursion 
 * @author Manish
 *
 */
public class QuickSort {
	//this method return the pivot element   
	int partition (int [] array,int left,int right){
		int pivot=array[left];
		while(left<=right){
			//increase the value of left if array[left] is less then pivot
			while(array[left]<pivot){
				left++;
			}
			//decrease the value of left if array[right] is greater then pivot
			while(array[right]>pivot){
				right--;
			}
			//swap the values of left and right position of array
			if(left<=right){
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	//this method divide the array into lower bound to pivot-1 and pivot to upper bound
	void quickSort (int [] array,int lowerBound,int upperBound){
		int pivot=partition(array,lowerBound,upperBound);	//get the pivot element 
		//call the method quick sort for the first half lower bound to pivot-1
		if(lowerBound<pivot-1){
			quickSort (array,lowerBound,pivot-1);
		}
		//call the method quick sort for the first half pivot to upper bound
		if(upperBound>pivot){
			quickSort (array,pivot,upperBound);
		}
	}
	
	public static void main(String[] args) {
		QuickSort object=new QuickSort();
		int array[]= {2,5,8,9,10, 77, 55, 11};
		object.quickSort(array,0,array.length-1);//call the quickSort method
		for(int i=0;i<array.length;i++){
			System.out.print(" "+array[i]);
		}
	}


}
