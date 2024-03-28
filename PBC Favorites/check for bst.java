class Solution {
    boolean isBSTUtil(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max)
            return false;
        return isBSTUtil(root.left, min, root.data) &&
               isBSTUtil(root.right, root.data, max);
    }
    boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
