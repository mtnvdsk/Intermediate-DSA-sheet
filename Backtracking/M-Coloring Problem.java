class Solve {
    // Function to determine if graph can be coloured with at most M colours
    // such that no two adjacent vertices of graph are coloured with the same colour.
    public static boolean isSafe(int i, int k, boolean[][] graph, int[] color) {
        for (int j = 0; j < graph.length; j++) {
            if (graph[j][i] && k == color[j]) {
                return false;
            }
        }
        return true;
    }

    public static boolean rec(boolean[][] graph, int[] color, int m, int n, int i) {
        if (i == n) {
            return true;
        }
        for (int k = 0; k < m; k++) {
            if (isSafe(i, k, graph, color)) {
                color[i] = k;
                if (rec(graph, color, m, n, i + 1)) {
                    return true;
                }
                color[i] = -1;
            }
        }
        return false;
    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return rec(graph, color, m, n, 0);
    }
}