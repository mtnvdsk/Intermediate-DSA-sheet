class Tree {
    ArrayList<Integer> postOrder(Node node) {
        Stack<Node> ans = new Stack<>();
        ArrayList<Integer> a = new ArrayList<>();

        if (node == null) {
            return a;
        }

        ans.push(node);
        while (!ans.isEmpty()) {
            Node current = ans.pop();
            a.add(0, current.data);

            if (current.left != null) {
                ans.push(current.left);
            }
            if (current.right != null) {
                ans.push(current.right);
            }
        }

        return a;
    }
}
