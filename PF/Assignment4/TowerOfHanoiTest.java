/**
 * Find the solution of tower of hanoi for n disks Junit test Case
 * @author Manish
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TowerOfHanoiTest {

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
	 * Positive test case
	 */
	@Test
	public void testTowerOfHanoi() {
		int expected[]={1,2,1,3,1,2,1};
		int array[]=new int[7];
		TowerOfHanoi.towerOfHanoi(3, 'A', 'B', 'C',array,0,array.length);
		assertArrayEquals(expected,array);
	}
	
	/*
	 * Negative test case
	 * here number of disks is negative number
	 */
	@Test(expected=StackOverflowError.class)
	public void testTowerOfHanoi1() {
		int array[]=new int[7];
		System.out.println("Please enter positive number of disks");
		TowerOfHanoi.towerOfHanoi(-2, 'A', 'B', 'C',array,0,array.length);
	}
}
