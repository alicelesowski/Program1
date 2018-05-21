/* Alice Lesowski
 * Data Structures and Algorithms
 * May 21, 2018
 * CSCI 232
 * 
 * Overview: This program takes numbers and commands from an input.txt file and inserts the numbers as nodes
 * into a binary tree. With each insert, the result in printed in Inorder Traversal.
 * The Program will find a specific node by user input, but only if the input is an integer.
 * If the node entered isn't in the tree, the user will be prompted again.
 * The inorder, postorder and preorder traversals are then printed and labeled.
 * Lastly, the min and max of the set is found.
 */

public class Node {
	public int key;
	public Node left;
	public Node right;
	
	public Node(int x){
		key=x;
		left = null;
		right = null;
	}
	
	public void showKey(){
		System.out.println(key);
	}
}
