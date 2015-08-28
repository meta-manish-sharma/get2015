package BinaryTree;
/**
 * this class implements the methods of binary tree class
 * @author Manish
 */
import java.util.Scanner;


public class BinaryTreeImplementation {
	
	public static void main (String args[]) {
		Scanner sc =new Scanner(System.in);
		BinaryTree btFirst = new BinaryTree();
		BinaryTree btSecond = new BinaryTree();
		//System.out.println("Enter number of element of tree");
		int choice ;
		int firstCount = 0,nFirst,secondCount=0,nSecond;
		do{
			System.out.println("Enter 1 for create first binary tree");
			System.out.println("Enter 2 for print preorder");
			System.out.println("Enter 3 for print postorder");
			System.out.println("Enter 4 for second binary tree");
			System.out.println("Enter 5 for check mirror");
			System.out.println("Enter 6 for exit");
			choice =sc.nextInt();
			switch(choice) {
			
				case 1 : System.out.println("Enter number of node of binary tree");
						nFirst=sc.nextInt();
						while(firstCount != nFirst) {
							Object item = sc.nextInt();
							btFirst.insert(item);
							firstCount++;
						}
					break;
					
				case 2 : System.out.println("--------PreOrder of tree------\n");
						btFirst.printPreorder();
						break;
						
				case 3 :  System.out.println("--------PostOrder of tree------\n" );
						btFirst.printPostorder();
						break;
					
				case 4 : System.out.println("Enter number of node for second binary tree");
						 nSecond=sc.nextInt();
						 while(secondCount != nSecond) {
						 	Object item = sc.nextInt();
							btSecond.insertMirror(item);
							secondCount++;
						 }
						 break;
						 
				case 5 :btSecond.printPostorder();
						System.out.println();
						System.out.print("are trees mirror --- ");
						//System.out.println(btFirst.preOrder);	
						String pre = btFirst.preOrder;
						String post = btSecond.postOrder;
						 if(pre.equals(post)){
							 System.out.println("true");
						 }
						 else {
							 System.out.println("false");
						 }
						break;
				case 6 : return;
				default : System.out.println("Please enter right input ");
						 
			}
		}while(true);
		
	}

}
