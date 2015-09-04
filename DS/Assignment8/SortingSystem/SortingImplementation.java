package SortingSystem;
/**
 *  sorting system, which takes input from user and provide a sorted list.
 *  Here User could choose if he want to go with Comparison Sorting Or Linear Sorting.
	Given Conditions: 
 1 - For comparison sorting system will use Bubble Sort or Quick Sort techniques 
 	(When less number of inputs (input elements <= 10) use Bubble Sort else Quicksort)
 2 - For linear sorting system will use Counting Sort or Radix Sort techniques
  	(When large inputs(more than 2 digit) use Radix Sort else Counting Sort)
 * @author Manish
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SortingImplementation {
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static ArrayList<Integer> result = new ArrayList<Integer>();
	static QuickSort qs = new QuickSort();
	static BubbleSort bs = new BubbleSort();
	static CountingSort cs = new CountingSort();
	static RadixSort rs = new RadixSort();
	
	
	public static void selectSort(int sortFlag){	
		result = new ArrayList<Integer>();
		result = list;
		
		//Comparison Sorting
		if(sortFlag == 1) {
			//if no of elements less or equal 10 then call bubble sort
			if(result.size()<=10) {
				System.out.println("----------Sort using Bubble sort-----------");
				bs.bubbleSorting(result);
			}
			//if no of elements greater then 10 then call bubble sort
			else {
					System.out.println("-------------Sort using Quick sort----------");
					qs.quickSort(result, 0, result.size()-1);
			}
		}
		
		//Linear Sorting
		else {
				//find maximum element in list
				int maxElement = 0;
				for(int i=0 ; i<result.size() ; i++) {
					if(result.get(i)>maxElement) {
						maxElement = result.get(i);
					}
				}
				//if maximum element less or equal 99 then call counting sort
				if(maxElement<=99) {
					System.out.println("------Sort using Counting sort---------");
					cs.countingSorting(result);
				}
				//if maximum element greater then 99 then call radix sort
				else {
					System.out.println("----------Sort using Radix sort----------");
					rs.radixsort(result);
				}
		}
		
	}
	
	static void display(){
		int i=0;
		while(!(i==result.size())) {
			System.out.print(" "+result.get(i++));
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String choice;
		String element,sortFlag;
		
		System.out.println("-----------Sorting System-------------------");
		while(true) {
			System.out.println("Press 1 to insert number for sorting");
			System.out.println("Press 2 to Sort numbers");
			System.out.println("Press 3 for exit ");
			choice = scan.nextLine();
			
			switch(choice) {
				case "1" :  do{
								System.out.println("Enter number");
								element = scan.nextLine();
							}while(!(element.matches("[0-9]+")));
							list.add(Integer.parseInt(element));
							break;
				
				case "2" :  do{
								System.out.println("---------Options------------");
								System.out.println("Press 1 to comparison sorting");
								System.out.println("Press 2 to linear sorting");
								sortFlag = scan.nextLine();
							}while(!(sortFlag.matches("[1-2]")));
							selectSort(Integer.parseInt(sortFlag));
							display();
							System.out.println("\n");
							break;
					
				case "3" : return;
				
				default : System.out.println("Please enter right input ");
			}
		}
	}
}
