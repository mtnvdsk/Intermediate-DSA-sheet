import java.util.ArrayList;
import java.util.List;

public class Main {
	static String direction = "DLRU";
	static int[] dr = {1, 0, 0, -1};
	static int[] dc = {0, -1, 1, 0};

	static boolean isValid(int r, int c, int n, List<List<Integer>> maze) {
		return r >= 0 && c >= 0 && r < n && c < n && maze.get(r).get(c) == 1;
	}

	static void findPath(int r, int c, List<List<Integer>> maze, int n, List<String> ans, StringBuilder currentPath) {
		if (r == n - 1 && c == n - 1) {
			ans.add(currentPath.toString());
			return;
		}

		maze.get(r).set(c, 0);

		for (int i = 0; i < 4; i++) {
			int nextr = r + dr[i];
			int nextc = c + dc[i];
			if (isValid(nextr, nextc, n, maze)) {
				currentPath.append(direction.charAt(i));
				findPath(nextr, nextc, maze, n, ans, currentPath);
				currentPath.deleteCharAt(currentPath.length() - 1);
			}
		}
		maze.get(r).set(c, 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> maze = new ArrayList<>();
		maze.add(new ArrayList<>(List.of(1, 0, 0, 0)));
		maze.add(new ArrayList<>(List.of(1, 1, 0, 1)));
		maze.add(new ArrayList<>(List.of(1, 1, 0, 0)));
		maze.add(new ArrayList<>(List.of(0, 1, 1, 1)));

		int n = maze.size();
		List<String> result = new ArrayList<>();
		StringBuilder currentPath = new StringBuilder();

		findPath(0, 0, maze, n, result, currentPath);

		if (result.isEmpty())
			System.out.println(-1);
		else
			result.forEach(path -> System.out.print(path + " "));
		System.out.println();
	}
}
