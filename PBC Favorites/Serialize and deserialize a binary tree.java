class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root == null) A.add(-1);
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    while(!q.isEmpty()){
	        Node node = q.poll();
	        if(node == null){
	            A.add(-1);
	            continue;
	        }
	        A.add(node.data);
	        q.offer(node.left);
	        q.offer(node.right);
	    }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        int n = A.size();
        if(n == 0) return null;
        Queue<Node> q =  new LinkedList<>();
        Node root = new Node(A.get(0));
        q.offer(root);
        for(int i=1;i<n;i++){
            Node parent = q.poll();
            if(A.get(i) != -1){
                Node left = new Node(A.get(i));
                parent.left = left;
                q.offer(left);
            }
            if(A.get(++i) != -1){
                Node right = new Node(A.get(i));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
};