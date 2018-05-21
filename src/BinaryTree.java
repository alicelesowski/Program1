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


public class BinaryTree {
	private Node root;
	
	public BinaryTree(){
		root = null;
	}
	
	public void insert(int k) {
		Node newNode = new Node(k);  
		newNode.key = k;	     
		newNode.left = null;
		newNode.right = null;
		root = insert2(root, k);
	}
	
	public Node insert2(Node current, int k) {
		if(current==null){
			Node node = new Node(k);
			return node;
		}
		if(k<current.key){
			current.left = insert2(current.left, k);
			}
		else if(k>current.key){
			current.right = insert2(current.right, k);
		}
		else{
			return current;
		}
		return current;
	}
		
	public Node find(int k){
		Node temp = root;
		do{
		if (temp.key==k){
			return root;
		}
		if(temp.key<k){
			temp=temp.right;
		}
		else{
			temp=temp.left;
		}
		if(temp == null){
			System.out.println("Node Not Found");
			return null;
		}	
		}while(temp.key!=k);
		return temp;
	}
		
	public Node min(){
		Node temp = root;
		do{
			temp=temp.left;	
		}while(temp.left!=null);
		return temp;
	}
	public Node max(){
		Node temp = root;
		do{
			temp=temp.right;
		}while(temp.right!=null);
		return temp;
			
		}
	public void traverse(int x){
		switch(x){
		case 1:
			inorder(root);
			break;
		case 2:
			postorder(root);
			break;
		case 3:
			preorder(root);
			break;
		}
	}

	public void inorder(Node temp){
			if (temp == null) {
				return;
			}
			else{
				inorder(temp.left);
				System.out.print(temp.key + " ");
				inorder(temp.right);
				return;
			}
	}
	public void postorder(Node temp){
			if (temp == null) {
				return;
			}
			else{
				postorder(temp.left);
				postorder(temp.right);
				System.out.print(temp.key + " ");
				return;
				}
	}
	public void preorder(Node temp){
			if (temp == null) {
				return;
			}
			else{
				System.out.print(temp.key + " ");
				preorder(temp.left);
				preorder(temp.right);	
				return;
				}
	}
	public void showTree(){
		inorder(root);
	}
}

