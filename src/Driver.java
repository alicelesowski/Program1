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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//Scanner del = new Scanner (System.in);
		BinaryTree tree = new BinaryTree();
		BufferedReader input = null;
		try{
			input = new BufferedReader(new FileReader("input/input.txt"));
			String line = null;
			String[] words;
			String[] num;
			String numToString;
			int[] intArr;
			
			while((line=input.readLine())!=null){
				words = line.split(" ");
				num = words[1].split(",");
				intArr = new int[num.length];
				for(int x=0; x<words.length; x++){
					System.out.println(words[x] +" ");
					for(int z=0; z<num.length; z++){
						numToString = num[z];
						intArr[z]= Integer.parseInt(numToString);}
					switch (words[x]){
					case "insert":
						System.out.println("Inserting... " + words[1] + "\nShown in Inorder Traversal after each insert:");
						for(int i=0; i<intArr.length; i++){
						tree.insert(intArr[i]);
						tree.showTree();
						System.out.println("\n");
						}
					case "find":
						int n;
						do{
						System.out.println("Enter node to Find: ");
						n = in.nextInt();
						}while(tree.find(n)==null);
						int f = tree.find(n).key;
						System.out.println("Found: "+ f + "\n");
						in.close();
					/*case "delete":
						int t;
						t=47;
						tree.find(t);
					    int d = tree.delete(t).key;
						System.out.println("Deleted: " + d);
						*/
					case "inorder":
						System.out.println("inorder: ");
						tree.traverse(1);
						System.out.println("\n");
					case "postorder":
						System.out.println("postorder: ");
						tree.traverse(2);
						System.out.println("\n");
					case "preorder":
						System.out.println("preorder: ");
						tree.traverse(3);
						System.out.println("\n");
					case "min":
						int p = tree.min().key;
						System.out.println("\nMin: " + p + "\n");
					case "max":
						int r = tree.max().key;
						System.out.println("Max: " + r);
					case "show":
						System.out.println("\n");
					default:
						return;
					}
						
						
					}}}
			
			catch(IOException x){
				System.err.format("IOException: %s%n", x);}
			}}
