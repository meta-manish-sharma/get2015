package BinaryTree;
/**
 * this class define the basic functions of binary tree
 * @author Manish
 *
 */

public class BinaryTree {
	
	Node root;
	String preOrder=""; 
	String	postOrder =""; 
	public BinaryTree() {
		root = null;
	}
	
	//to create binary tree
	public void insert(Object item) { 
	    root = insert(root, item); 
	  }
	
	 private Node insert(Node node, Object data) { 
	    if (node==null) { 
	      node = new Node(data); 
	    } 
	    else { 
	      if ((int)data <= (int)node.data) { 
	        node.left = insert(node.left, data); 
	      } 
	      else { 
	        node.right = insert(node.right, data); 
	      } 
	    }

	    return(node); // in any case, return the new pointer to the caller 
	  } 
	 
	 //to create mirror of binary tree
	 public void insertMirror(Object item) { 
		    root = insertMirror(root, item); 
		  }
		
		 private Node insertMirror(Node node, Object data) { 
		    if (node==null) { 
		      node = new Node(data); 
		    } 
		    else { 
		      if ((int)data >= (int)node.data) { 
		        node.left = insertMirror(node.left, data); 
		      } 
		      else { 
		        node.right = insertMirror(node.right, data); 
		      } 
		    }

		    return(node); // in any case, return the new pointer to the caller 
		  } 

		 

	 //this method find the preOrder of binary tree 
	 public String printPreorder() { 
		 preOrder = printPreorder(root); 
		 System.out.println(); 
		 return preOrder;
	}
	
	public String printPreorder(Node node) { 
		 if (node == null) return preOrder;
		 	// first deal with the node 
		 	preOrder+=node.data;
		 	System.out.print(node.data + "  ");

		 	// then deal with recur on both subtrees 
		 	printPreorder(node.left); 
		 	printPreorder(node.right);
		 	return preOrder;
	}
	 
	 
	//this method find the inOrder of binary tree
	 public void printTree() { 
		 printTree(root); 
		 System.out.println(); 
		}
	 
		private void printTree(Node node) { 
		 if (node == null) return;

		 // left, node itself, right 
		 printTree(node.left); 
		 System.out.print(node.data + "  "); 
		 printTree(node.right); 
		}
		
		
		//this method find the postOrder of binary tree
		public String printPostorder() { 
			 postOrder=printPostorder(root); 
			 System.out.println();
			 return postOrder;
		}
		
		public String printPostorder(Node node) { 
			 if (node == null) return "";

			  // first recur on both subtrees 
			  printPostorder(node.left); 
			  printPostorder(node.right);

			  // then deal with the node 
			 postOrder= node.data+postOrder;
			 System.out.print(node.data + "  ");
			 return postOrder;
		} 
		
		
}