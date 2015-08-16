/***
 * Junit test case for Circle class
 * @author Manish
 */

package Interface_Implemantation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Manish
 *
 */
public class CircleTest {

	
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
	
	Shape circle=new Circle(3); //Creating object of class Circle
	
	//This test case check the getArea method
	@Test
	public void testToGetArea() {
		double expected=28.26;
		assertEquals(expected,circle.getArea(),0.01);
	}
	
	
	//This test case check the draw method
	@Test
	public void testToDraw() {
		String expected="This is circle ";
		assertEquals(expected,circle.draw());
	}
	
}
