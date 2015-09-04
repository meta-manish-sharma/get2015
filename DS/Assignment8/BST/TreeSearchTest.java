package BST;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeSearchTest {
	static BinarySearchTree binaryTree = new BinarySearchTree();
	static BinarySearchTree bst = new BinarySearchTree();
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

		
	@Test//test insert method
	public void testInsert() {
		Node node = binaryTree.insert(12);
		if(((int)node.data==12) && (node.left==null) && (node.right==null)){
		}
		else {
			fail("Insert method fails");
		} 	
	}
	
	@Test//test tree sorting method
	public void testInOrder() {
	 	String expected = "481012161820";
		binaryTree.insert(8);
		binaryTree.insert(4);
		binaryTree.insert(10);
		binaryTree.insert(18);
		binaryTree.insert(16);
		binaryTree.insert(20);
		String result = binaryTree.printTree();
		assertEquals(expected, result);
			
}

	//negative test case when inserting string and integer elements together
	@Test(expected = ClassCastException.class)
	public void testInOrdernegative() {
		bst.insert("abcd");
		bst.insert(12);	
	}

}
