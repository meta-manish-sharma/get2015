package SortingSystem;

import java.util.ArrayList;

public class RadixSort {

	public void radixsort(ArrayList<Integer> array) {
		// declare and initialize bucket[]
		ArrayList<Integer>[] bucket = new ArrayList[10];
		for (int bucketNumber = 0; bucketNumber < bucket.length; bucketNumber++) {
			bucket[bucketNumber] = new ArrayList<Integer>();
		}

		// sort
		boolean maxLength = false;
		int tmp = -1, placement = 1;
		
		
		
		while (!maxLength) {
			maxLength = true;
			
			// split input between lists
			for (Integer element : array) {
				tmp = element / placement;
				bucket[tmp % 10].add(element);
				if (tmp > 0) {
					maxLength = false;
				}
			}

			// empty lists into input array
			int index = 0;
			for (int bucketNumber = 0; bucketNumber < 10; bucketNumber++) {
				for (Integer element : bucket[bucketNumber]) {
					array.set(index++, element);
				}
				bucket[bucketNumber].clear();
			}
			// move to next digit
			placement *= 10;
		}
	}

}
