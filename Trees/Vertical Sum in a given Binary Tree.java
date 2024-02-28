import java.util.TreeMap;
class TreeNode {
	private int key;
	private TreeNode left;
	private TreeNode right;
	public int key()	 { return key; }
	public TreeNode left() { return left; }
	public TreeNode right() { return right; }
	public TreeNode(int key)
{ this.key = key; left = null; right = null; }
	public void setLeft(TreeNode left) { this.left = left; }
	public void setRight(TreeNode right) { this.right = right; }
}
class Tree {

	private TreeNode root;
	public Tree() { root = null; }
	public Tree(TreeNode n) { root = n; }
	public void VerticalSumMain() { VerticalSum(root); }
	private void VerticalSum(TreeNode root) {
		if (root == null) { return; }
		TreeMap<Integer, Integer> hM =
				new TreeMap<Integer, Integer>();
		VerticalSumUtil(root, 0, hM);
		if (hM != null) {
			System.out.println(hM.entrySet());
		}
	}
	private void VerticalSumUtil(TreeNode root, int hD,
						TreeMap<Integer, Integer> hM) {
		if (root == null) { return; }
		VerticalSumUtil(root.left(), hD - 1, hM);
		int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
		hM.put(hD, prevSum + root.key());

		VerticalSumUtil(root.right(), hD + 1, hM);
	}
}

public class Main {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.left().setLeft(new TreeNode(4));
		root.left().setRight(new TreeNode(5));
		root.right().setLeft(new TreeNode(6));
		root.right().setRight(new TreeNode(7));
		Tree t = new Tree(root);

		System.out.println("Following are the values of" + 
						" vertical sums with the positions" +
						" of the columns with respect to root ");
		t.VerticalSumMain();
	}
}
