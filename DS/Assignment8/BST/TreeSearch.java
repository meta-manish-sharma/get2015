package BST;

import java.util.Scanner;

public class TreeSearch {
	
	public static void main(String args[]) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		Scanner scan;
		String choice;
		String element;
		String ragix = "[0-9]+";
		while(true){
			scan = new Scanner(System.in);
			System.out.println("Enter 1 to insert element");
			System.out.println("Enter 2 to show sorted data");
			System.out.println("Enter 3 to exit");
			choice = scan.nextLine();
			switch(choice) {
			case "1" : 
						do {
							System.out.println("Enter roll number of student");
							element = scan.nextLine();	
						}while(!(element.matches(ragix)));
						
						binaryTree.insert(Integer.parseInt(element));
						break;
			
			case "2" : 	System.out.println("Enter element");
						binaryTree.printTree();
						break;
			
			case "3" : return;
			
			default :  System.out.println("please enter right input");
			}
			
		}
	}
}
