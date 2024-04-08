import java.io.*;
import java.util.*;

class pair {
	int Item1, Item2;
	pair(int f, int s)
	{
		Item1 = f;
		Item2 = s;
	}
}

class GFG {

	static int row = 5;
	static int col = 5;
	static boolean isPath(int[][] arr)
	{
		int[][] dir
			= { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0, 0));
		while (q.size() > 0) {
			pair p = (q.peek());
			q.remove();
			arr[p.Item1][p.Item2] = -1;
			if (p.Item1 == row - 1 && p.Item2 == col - 1)
				return true;
			for (int i = 0; i < 4; i++) {
				int a = p.Item1 + dir[i][0];
				int b = p.Item2 + dir[i][1];
				if (a >= 0 && b >= 0 && a < row && b < col
					&& arr[a][b] != -1) {
					if (a == row - 1 && b == col - 1)
						return true;

					q.add(new pair(a, b));
				}
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		int[][] arr = { { 0, 0, 0, -1, 0 },
						{ -1, 0, 0, -1, -1 },
						{ 0, 0, 0, -1, 0 },
						{ -1, 0, 0, 0, 0 },
						{ 0, 0, -1, 0, 0 } };
		if (isPath(arr))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
