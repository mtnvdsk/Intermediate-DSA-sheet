class Solution {
    int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] ans = new int[1];
        solve(map, ans, root);
        return ans[0];
    }

    String solve(Map<String, Integer> map, int[] ans, Node root) {
        if (root == null) {
            return "#";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.data);
        }
        String a = solve(map, ans, root.left) +','+ solve(map, ans, root.right) +','+ Integer.toString(root.data);
        map.put(a, map.getOrDefault(a, 0) + 1);
        if (map.getOrDefault(a, 0) > 1) {
            ans[0] = 1;
        }


        return a;
    }
}