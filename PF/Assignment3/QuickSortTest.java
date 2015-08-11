/**
 * Junut test case Quick sort using recursion 
 * @author Manish
 *
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class QuickSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	QuickSort object=new QuickSort(); //object of class QuickSort created
	/*
	 * Positive Test Case*/
	@Test
	public void testQuickSort() {
		int array[]= {2,5,8,9,10, 77, 55, 11};
		int expacted[]={2,5,8,9,10,11,55,77};
		object.quickSort(array, 0, array.length-1);
		assertArrayEquals(expacted,array);
	}
	
	/*
	 * Negative Test Case
	 * here is the array is empty*/
	@Test(expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void testQuickSort1() {
		int array[]= {};
		System.out.println("Array is empty");
		object.quickSort(array, 0, array.length-1);
	}

}
