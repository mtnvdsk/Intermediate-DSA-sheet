import java.util.*;
class AdjListNode {
	private int v;
	private int weight;

	AdjListNode(int _v, int _w)
	{
		v = _v;
		weight = _w;
	}
	int getV() { return v; }
	int getWeight() { return weight; }
}
public class GFG {
	int V;
	ArrayList<AdjListNode>[] adj;
	@SuppressWarnings("unchecked")

	GFG(int V)
	{
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	void addEdge(int u, int v, int weight)
	{
		AdjListNode node = new AdjListNode(v, weight);
		adj[u].add(node);
	}
	void topologicalSortUtil(int v, boolean visited[],
							Stack<Integer> stack)
	{
		visited[v] = true;
		for (int i = 0; i < adj[v].size(); i++) {
			AdjListNode node = adj[v].get(i);
			if (!visited[node.getV()])
				topologicalSortUtil(node.getV(), visited,
									stack);
		}
		stack.push(v);
	}
	void longestPath(int s)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int dist[] = new int[V];
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[s] = 0;
		while (stack.isEmpty() == false) {
			int u = stack.peek();
			stack.pop();
			if (dist[u] != Integer.MAX_VALUE) {
				for (AdjListNode v : adj[u]) {
					if (dist[v.getV()]
						> dist[u] + v.getWeight() * -1)
						dist[v.getV()]
							= dist[u] + v.getWeight() * -1;
				}
			}
		}
		for (int i = 0; i < V; i++)
			if (dist[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] * -1 + " ");
	}
	public static void main(String args[])
	{
		GFG g = new GFG(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int s = 1;
		System.out.print(
			"Following are longest distances from source vertex "
			+ s + " \n");
		g.longestPath(s);
	}
}
