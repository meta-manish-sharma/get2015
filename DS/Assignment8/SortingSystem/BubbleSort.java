package SortingSystem;

import java.util.ArrayList;

public class BubbleSort {
	
	//method perform bubble sort
	public void bubbleSorting(ArrayList<Integer> list) {
		for(int i=0 ; i < list.size(); i++) {
			for(int j=0; j<list.size()-i-1; j++) {
				//if jth element is greater then j+1th element
				//then swap jth element with j+1th element 
				if(list.get(j)>list.get(j+1)) {
					Integer temp= list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
	}
}
