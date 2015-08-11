/**
 * Find greatest common divisor using recursion junit test case 
 * @author Manish
 *
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FindGreatestCommonDevisorTest {

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
	FindGreatestCommonDevisor object=new FindGreatestCommonDevisor();//create object of FindGreatestCommonDevisor
	/*
	 * Positive Test Case*/
	@Test
	public void testGetRemainder() {
		int expacted=6;
		assertEquals(expacted,object.getGcd(12,18));
	}

}
