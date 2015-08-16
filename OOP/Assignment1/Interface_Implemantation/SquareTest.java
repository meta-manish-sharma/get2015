/***
 * Junit test case for Square class
 * @author Manish
 */
package Interface_Implemantation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SquareTest {

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
	
	Shape square=new Square(4);	//Creating object of class square
	
	//This test class test the getArea method
	@Test
	public void testToGetArea() {
		double expected=16.0;
		assertEquals(expected,square.getArea(),0.01);
	}
	//This test case check the draw method
	@Test
	public void testToDraw() {
		String expected="This is square ";
		assertEquals(expected,square.draw());
	}

}
