// Java program to evaluate expression tree
import java.lang.*;

class Solution{
	
Node root;
public static class Node 
{
	String data;
	Node left, right;

	Node(String d)
	{
		data = d;
		left = null;
		right = null;
	}
}
public static int evalTree(Node root)
{
	if (root == null)
		return 0;
	if (root.left == null && root.right == null)
		return Integer.parseInt(root.data);

	int leftEval = evalTree(root.left);

	int rightEval = evalTree(root.right);

	if (root.data.equals("+"))
		return leftEval + rightEval;

	if (root.data.equals("-"))
		return leftEval - rightEval;

	if (root.data.equals("*"))
		return leftEval * rightEval;

	return leftEval / rightEval;
}

public static void main(String[] args)
{
	Node root = new Node("+");
	root.left = new Node("*");
	root.left.left = new Node("5");
	root.left.right = new Node("-4");
	root.right = new Node("-");
	root.right.left = new Node("100");
	root.right.right = new Node("20");
	System.out.println(evalTree(root));

	root = null;
	root = new Node("+");
	root.left = new Node("*");
	root.left.left = new Node("5");
	root.left.right = new Node("4");
	root.right = new Node("-");
	root.right.left = new Node("100");
	root.right.right = new Node("/");
	root.right.right.left = new Node("20");
	root.right.right.right = new Node("2");
	System.out.println(evalTree(root));
}
}
