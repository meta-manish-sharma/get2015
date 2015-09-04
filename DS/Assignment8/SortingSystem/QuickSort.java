package SortingSystem;

import java.util.ArrayList;

public class QuickSort {
	
	 //this method return the pivot element  
	int partition (ArrayList<Integer> array,int left,int right){
		int pivot = left;
		int storeIndex = pivot+1;
		
		for(int i = pivot+1; i<=right; i++) {
			//check which element greater at position i and pivot
			if(array.get(i)<array.get(pivot)) {
				//swap element at position i and storeIndex
				Integer t =array.get(i);
				array.set(i, array.get(storeIndex));
				array.set(storeIndex, t);
				storeIndex++;
			}
		}
		//swap element at position p and storeIndex-1
		Integer i = array.get(pivot);
		array.set(pivot, array.get(storeIndex-1));
		array.set(storeIndex-1, i);
		return pivot;
	}
	
	//this method divide the array into lower bound to pivot-1 and pivot to upper bound
	void quickSort (ArrayList<Integer> array,int lowerBound,int upperBound){
		int pivot=partition(array,lowerBound,upperBound);	//get the pivot element 
		//call the method quick sort for the first half lower bound to pivot-1
		if(lowerBound<pivot-1){
			quickSort (array,lowerBound,pivot-1);
		}
		//call the method quick sort for the first half pivot to upper bound
		if(upperBound>pivot){
			quickSort (array,pivot+1,upperBound);
		}
	}
}
