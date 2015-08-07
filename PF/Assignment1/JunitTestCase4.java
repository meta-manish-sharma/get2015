import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JunitTestCase4 {

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
	
	public int isArrayEqual(int expected[][], int output[][])
	{
		int result=1;
		int col=expected[0].length;
		int row=expected.length;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(expected[i][j]!=output[i][j])
					result=0;
			}
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println("Test4");
		Assignment4 assignment4=new Assignment4();
		JunitTestCase4 junittestcase4=new JunitTestCase4();
		int[] arrival={1,5,9,25};
		int[] job_size={12,7,2,5};
		int n=4;
		
		int[][] output=assignment4.FCFS(arrival,job_size,n);
		int[][] expected={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		
		assertEquals(1,junittestcase4.isArrayEqual(expected,output));
	}

	}
