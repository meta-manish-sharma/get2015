/*TestCase for pyramid as follows
 *      1
      1 2 1
    1 2 3 2 1
  1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1
  1 2 3 4 3 2 1
    1 2 3 2 1
	  1 2 1
	    1

*/
	import static org.junit.Assert.*;

	import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


	public class CreatePyramidTest {

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
		
		CreatePyramid tester=new CreatePyramid();     //creating object of Pyramid class
		
		@Test//test case to check spaces
		public void testForSpaces(){
			String[] expected={"    ","   ","  "," ",""," ","  ","   ","    "};
			assertArrayEquals(expected, tester.spaces(9, 5));
			
		}
		
		@Test//test case to check numbers
		public void testForNumbers(){
			String[] expected={"1","121","12321","1234321","123454321","1234321","12321","121","1"};
			assertArrayEquals(expected, tester.numbers(9, 5));
			
		}
		
		@Test//Positive Test Case
		public void ptestForfullPatternFunction(){
			String[] input1=tester.spaces(9, 5);//Get the strings of spaces
			String[] input2=tester.numbers(9, 5);//Get the strings of numbers
			String[] expected={"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
			assertArrayEquals(expected, tester.printWholePyramid(input1,input2,9));
			
		}
		
		@Test//Negative Test Case
		public void ntestForfullPatternFunction(){
			String[] input1=tester.spaces(9, 5);//Get the strings of spaces
			String[] input2=tester.numbers(9, 5);//Get the strings of numbers
			String[] expected={"    1 ","   121","  12321"," 1234321","123454321","    1","   121","  12321"," 1234321"};
			assertArrayEquals(expected, tester.printWholePyramid(input1,input2,9));
			
		}
		
		
	}

