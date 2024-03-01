import java.util.*;
class solution
    {
    static class Node 
    { 
        int key; 
        Node left, right; 
        boolean isThreaded; 
    }; 
    static Node createThreaded(Node root) 
    { 
        if (root == null) 
            return null; 
        if (root.left == null && 
            root.right == null) 
            return root; 
        if (root.left != null) 
        { 
            Node l = createThreaded(root.left); 
            l.right = root; 
            l.isThreaded = true; 
        } 
        if (root.right == null) 
            return root; 
        return createThreaded(root.right); 
    } 
    static Node leftMost(Node root) 
    { 
        while (root != null && root.left != null) 
            root = root.left; 
        return root; 
    } 
    static void inOrder(Node root) 
    { 
        if (root == null) return; 
        Node cur = leftMost(root); 
    
        while (cur != null) 
        { 
            System.out.print(cur.key + " "); 
            if (cur.isThreaded) 
                cur = cur.right; 
    
            else
                cur = leftMost(cur.right); 
        } 
    } 
    static Node newNode(int key) 
    { 
        Node temp = new Node(); 
        temp.left = temp.right = null; 
        temp.key = key; 
        return temp; 
    } 
    public static void main(String args[])
    { 
        Node root = newNode(1); 
        root.left = newNode(2); 
        root.right = newNode(3); 
        root.left.left = newNode(4); 
        root.left.right = newNode(5); 
        root.right.left = newNode(6); 
        root.right.right = newNode(7); 
    
        createThreaded(root); 
    
        System.out.println("Inorder traversal of created "+"threaded tree is\n"); 
        inOrder(root); 
    } 
    }
    