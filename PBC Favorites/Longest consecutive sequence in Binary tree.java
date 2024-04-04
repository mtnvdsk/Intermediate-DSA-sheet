class Solution
{
	public int longestConsecutive(Node root)
    {
        //add code here.
        int[] result = new int[1];
        lcs(root, 1, result);
        
        return result[0] == 1 ? -1 : result[0];
    }
    
    public void lcs(Node root, int currentSequence, int[] result) {
        result[0] = Math.max(currentSequence, result[0]);
        if(root == null) return;
        
        if(root.left != null) {
            if(root.left.data == root.data + 1) {
                lcs(root.left, currentSequence + 1, result);
            } else {
                lcs(root.left, 1, result);
            }
        }
        
        if(root.right != null) {
            if(root.right.data == root.data + 1) {
                lcs(root.right, currentSequence + 1, result);
            } else {
                lcs(root.right, 1, result);
            }
        }
    }
}