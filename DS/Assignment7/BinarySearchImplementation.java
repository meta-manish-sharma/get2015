import java.util.Scanner;
/**
 * Write a program the binary search function and its loop invariants in a way so
 * that it will always find the leftmost occurrence of x in the array in case the occurrences are not unique
 *(if it is actually in the array, −1 as before if it is not).
 * @author Manish
 *
 */

public class BinarySearchImplementation {
	
	//main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int array[], n;
		
		System.out.println("Enter the length of array");
		n=scan.nextInt();
		
		array = new int[n];
		System.out.println("Enter elements of array");
		
		for(int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		
		System.out.println("Enter elements to search");
		int element = scan.nextInt();
		//call binarySearch methyod
		int index = new NewBinarySearch().binarySearch(array, element, 0, n-1);
		//check index equal -1 then element not found
		if(index==-1){
			System.out.println("Element ("+element+") not found in array");
		}
		//print element position in array
		else {
			System.out.println("Element found at "+index+" Position");
		}
	}
}
