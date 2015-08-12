/**
 * Find all possible permutation for string Junit test case
 * @author Manish
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GeneratePermutationsTest {

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
	
	//This function compare the array of strings of expected and get by method
	int compareList(ArrayList<String> list, String[] expected){
		int flag = 1;
		int i=0;
		String str[]=new String[6];	
		Iterator<String> iterator = ((ArrayList<String>) list).iterator();
		while (iterator.hasNext()) {
			str[i]=iterator.next();
			i++;
		}
		for(int j=0;j<6;j++){
			System.out.print("  "+str[j]);
		}
		for(int j=0;j<6;j++){
			if(!(expected[j].equals(str[j]))){
				flag=0;
				break;
			}
		}
		System.out.print("  "+flag+"  ");
		return flag;
	}
	
	/*
	 * Positive test case
	 */
	@Test
	public void testOfPermutation1() {
		ArrayList<String> list=new ArrayList<String>();
		String expected[]={"ABC","ACB","BAC","BCA","CAB","CBA"};
		GeneratePermutations.permuteString("","ABC",list);
		assertEquals(1,this.compareList(list,expected));
	}
	
	

}
