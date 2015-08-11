/**
 * Binary search using recursion junit test case 
 * @author Manish
 *
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarySearchTest {

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

	BinarySearch object=new BinarySearch(); //object of class BinarySearch created
	/*
	 * Positive Test Case*/
	@Test
	public void testGetRemainder() {
		int array[]= {2,5,8,9,10, 55, 77};
		int expacted=7;
		System.out.println(expacted);
		assertEquals(expacted,object.search(array,0,array.length,77));
	}
	
	/*
	 * Negative Test Case
	 * here element is not present in array*/
	@Test 
	public void testGetRemainder1() {
		int array[]= {2,5,8,9,10, 55, 77};
		int expacted=-1;
		assertEquals(expacted,object.search(array,0,array.length,99));
	}


}
