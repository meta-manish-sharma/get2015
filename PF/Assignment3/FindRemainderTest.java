/**
 * Find remainder using recursion junit test case 
 * @author Manish
 *
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FindRemainderTest {

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
	
	/*
	 * Positive Test Case*/
	@Test
	public void testGetRemainder() {
		int expacted=1;
		FindRemainder object=new FindRemainder();
		assertEquals(expacted,object.getRemainder(100,3));
	}
	
	/*
	 * Negative Test Case*/
	@Test //here deviser is zero so function return -1
	public void testGetRemainder1() {
		int expacted=-1;
		FindRemainder object=new FindRemainder();
		assertEquals(expacted,object.getRemainder(100,0));
	}

}
