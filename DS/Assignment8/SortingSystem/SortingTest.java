package SortingSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortingTest {
	static ArrayList<Integer> list;
	static ArrayList<Integer> negativelist;
	RadixSort radix = new RadixSort();
	CountingSort count = new CountingSort();
	BubbleSort bubble = new BubbleSort();
	QuickSort quick = new QuickSort();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		negativelist = new ArrayList<Integer>();
		negativelist.add(15);
		negativelist.add(-12);
		negativelist.add(100);
		list = new ArrayList<Integer>();
		list.add(18);
		list.add(55);
		list.add(100);
		list.add(3);
		list.add(1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	 @Test//positive test case for radix sort
	 public void testRadixsort() {
		 System.out.println("radixsort positive test case");   
		 ArrayList<Integer> radixlist = new ArrayList<Integer>();
		 radixlist= list;
		 radix.radixsort(list);
		 for (int i = 1; i < radixlist.size(); i++) {
		     if (radixlist.get(i-1) > radixlist.get(i)) {
		        fail("radixsort method fails.");
		     }
		 }
	}
	 
	 //negative test case for radix sort
	 @Test(expected = ArrayIndexOutOfBoundsException.class)
	 public void testRadixSortNegative() {
		 System.out.println("radixsort negative test case");
		 radix.radixsort(negativelist);
	 }	 
	 
	 @Test//Positive test case for quick sort
	 public void testQuickSort() {
		 System.out.println("Quicksort positive test case");   
		 ArrayList<Integer> quicklist = new ArrayList<Integer>();
		 quicklist= list;
		 quick.quickSort(quicklist, 0, quicklist.size()-1);
		 for (int i = 1; i < quicklist.size(); i++) {
		     if (quicklist.get(i-1) > quicklist.get(i)) {
		        fail("Quicksort method fails.");
		     }
		 }
	}
	 
	 //Negative test case for quick sort
	 @Test(expected = AssertionError.class)
	 public void testQuickSortNegative() {
		 System.out.println("Quicksort negative test case");
		 quick.quickSort(negativelist, 0, negativelist.size()-1);
		 assertFalse(true);
	 }
	 
	 @Test//Positive test case for bubble sort
	 public void testBubbleSort() {
		 System.out.println("Bubblesort positive test case");   
		 ArrayList<Integer> bubblelist = new ArrayList<Integer>();
		 bubblelist= list;
		 bubble.bubbleSorting(bubblelist);
		 for (int i = 1; i < bubblelist.size(); i++) {
		     if (bubblelist.get(i-1) > bubblelist.get(i)) {
		        fail("bubblesort method fails.");
		     }
		 }
	}
	 
	 @Test//Negative test case for bubble sort
	 public void testBubbleSortNegativeValues() {
		 System.out.println("bubblesort negative test case");
		 ArrayList<Integer> nbubble = new ArrayList<Integer>();
		 nbubble = negativelist;
		 bubble.bubbleSorting(nbubble);
		 System.out.println();
		 for(Integer i: nbubble){
			 System.out.print(" "+i);
		 }
		 System.out.println();
	 } 
	 
	 @Test//Positive test case for Counting sort
	 public void testCountingSort() {
		 System.out.println("Countingsort positive test case");   
		 ArrayList<Integer> countlist = new ArrayList<Integer>();
		 countlist= list;
		 count.countingSorting(countlist);
		 for (int i = 1; i < countlist.size(); i++) {
		     if (countlist.get(i-1) > countlist.get(i)) {
		        fail("countingsort method fails.");
		     }
		 }
	}
	 
	 //Negative test case for Counting sort
	 @Test(expected = ArrayIndexOutOfBoundsException.class)
	 public void testCountingSortNegativeValues() {
		 System.out.println("Countingsort negative test case");
		 ArrayList<Integer> ncount = new ArrayList<Integer>();
		 ncount = negativelist;
		 count.countingSorting(ncount);
	 }
	 
}
