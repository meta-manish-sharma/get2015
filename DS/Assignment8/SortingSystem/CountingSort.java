package SortingSystem;

import java.util.ArrayList;

public class CountingSort {
	
	//sort array list using counting sorting
	public void countingSorting(ArrayList<Integer> array ) {
		int maxElement = 0;
		//find maximum element in list
		for(int i=0 ; i<array.size() ; i++) {
			if(array.get(i)>maxElement) {
				maxElement = array.get(i);
			}
		}
		
		//create array of maximum element size
		int [] counting = new int[maxElement+1];
		
		//set the corresponding entry in counting array for each element
		for(int i = 0; i<array.size();i++) {
			counting[array.get(i)]++;
		}
		
		//restore the list in sorted order
		int count = 0;
		for(int i = 0;i<=maxElement;i++){
			while(counting[i]!=0){
				array.set(count, i);
				counting[i]--;
				count++;
			}
		}	
	}
}

