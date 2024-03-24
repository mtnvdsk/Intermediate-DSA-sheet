import java.io.*;
import java.util.*;

class Solution
{
	static int WHITE = 0, GRAY = 1, BLACK = 2;
	static class Graph 
	{
			int V;
			LinkedList<Integer>[] adjList;
			Graph(int ver)
			{
				V = ver;
				adjList = new LinkedList[V];
				for (int i = 0; i < V; i++)
					adjList[i] = new LinkedList<>();
			}
	}

	static void addEdge(Graph g, int u, int v)
	{
			g.adjList[u].add(v);
	}
 
	static boolean DFSUtil(Graph g, int u, int[] color) 
	{
			color[u] = GRAY;
			for (Integer in : g.adjList[u]) 
			{
				if (color[in] == GRAY)
					return true;
				if (color[in] == WHITE && DFSUtil(g, in, color) == true)
					return true;
			}

			color[u] = BLACK;
			return false;
	}

	static boolean isCyclic(Graph g)
	{
			int[] color = new int[g.V];
			for (int i = 0; i < g.V; i++)
			{
				color[i] = WHITE;
			}
			for (int i = 0; i < g.V; i++) 
			{
				if (color[i] == WHITE)
				{
					if(DFSUtil(g, i, color) == true) 
						return true;
				} 
			}
			return false;

	}

	public static void main(String args[])
	{
			Graph g = new Graph(4);
			addEdge(g, 0, 1);
			addEdge(g, 0, 2);
			addEdge(g, 1, 2);
			addEdge(g, 2, 0);
			addEdge(g, 2, 3);
			addEdge(g, 3, 3);
			if (isCyclic(g))
				System.out.println("Graph contains cycle");
			else
				System.out.println("Graph doesn't contain cycle");
	}
}
