class Solution {
    void mirror(Node root) {
        if (root == null) return;
        mirror(root.left);
        mirror(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
    }
}