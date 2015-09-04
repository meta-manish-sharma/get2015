package BST;
/**
 * this class define the basic functions of binary tree
 * @author Manish
 *
 */

public class BinarySearchTree {
		Node root;
		String inOrder=""; 
		public BinarySearchTree() {
			root = null;
		}
		
		//to create binary tree
		public Node insert(Object item) { 
		    root = insert(root, item);
		    return root;
		  }
		
		 private Node insert(Node node, Object data) { 
		    if (node==null) { 
		      node = new Node(data); 
		    } 
		    else { 
		      if ((int)data < (int)node.data) { 
		        node.left = insert(node.left, data); 
		      } 
		      else { 
		        node.right = insert(node.right, data); 
		      } 
		    }

		    return(node); // in any case, return the new pointer to the caller 
		  } 

		//this method find the inOrder of binary tree
		 public String printTree() { 
			 inOrder = printTree(root); 
			 System.out.println();
			 return inOrder;
			}
		 
			private String printTree(Node node) { 
			 if (node == null) return inOrder;

			 // left, node itself, right 
			 printTree(node.left); 
			 inOrder+=node.data;
			 System.out.print(node.data + "  "); 
			 printTree(node.right);
			 return inOrder;
			}
}
