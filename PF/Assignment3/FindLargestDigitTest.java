/**
 * Find largest digit using recursion junit test case 
 * @author Manish
 *
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FindLargestDigitTest {

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
	FindLargestDigit object=new FindLargestDigit(); //create object of FindLargestDigit
	/*
	 * Positive Test Case*/
	@Test
	public void testGetRemainder() {
		int expacted=1;
		FindRemainder object=new FindRemainder();
		assertEquals(expacted,object.getRemainder(100,3));
	}
	
	

}
