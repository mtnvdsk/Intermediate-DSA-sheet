class Node {
	int time;
	Node left, right;

	Node(int time)
	{
		super();
		this.time = time;
	}
};
Node newNode(int item)
{
	Node temp = new Node(item);
	return temp;
}
Node insert(Node root, int time, int k)
{
	if (root == null)
		return newNode(time);
	if ((time - k < root.time) && (time + k > root.time))
		return root;
	if (time < root.time)
		root.left = insert(root.left, time, k);
	else
		root.right = insert(root.right, time, k);
	return root;
}
