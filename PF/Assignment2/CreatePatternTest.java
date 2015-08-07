/*TestCase for pattern as follows
 *  1 2 3 4 5 
 	 1 2 3 4 
       1 2 3 
         1 2 
           1 
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CreatePatternTest {

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
	
	CreatePattern tester=new CreatePattern();     //creating object of CreatePattern class
	
	@Test//test case to check spaces
	public void testForSpaces(){
		String[] expected={null," ","  ","   ","    "};
		assertArrayEquals(expected, tester.spaces(5, 5));
		
	}
	
	@Test//test case to check numbers
	public void testForNumbers(){
		String[] expected={"12345","1234","123","12","1"};
		assertArrayEquals(expected, tester.numbers(5, 5));
		
	}

	
	@Test//Positive Test Case for pyramid
	public void ptestForfullPatternFunction(){
		String[] input1=tester.spaces(5, 5);//Get the strings of spaces
		String[] input2=tester.numbers(5, 5);//Get the strings of numbers
		String[] expected={"12345"," 1234","  123","   12","    1"};
		assertArrayEquals(expected, tester.printWholePyramid(input1,input2,5));
		
	}
	
	@Test//Negative Test Case for pyramid
	public void ntestForfullPatternFunction(){
		String[] input1=tester.spaces(5, 5);//Get the strings of spaces		
		String[] input2=tester.numbers(5, 5);//Get the strings of numbers
		String[] expected={"12345"," 1234","  123","   12","    12"};
		assertArrayEquals(expected, tester.printWholePyramid(input1,input2,5));
		
	}
	
	
}

