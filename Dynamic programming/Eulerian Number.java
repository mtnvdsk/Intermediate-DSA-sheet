import java.util.*;

public class Main {
	static int eulerian(int n, int m) {
		int[] dp = new int[m+1];
		Arrays.fill(dp, 0);
		for (int i = 1; i <= n; i++) {
			int prev = 0;
			for (int j = 0; j <= m; j++) {
				int temp = dp[j];
				if (i > j) {
					if (j == 0)
						dp[j] = 1;
					else
						dp[j] = ((i - j) * prev) + ((j + 1) * dp[j]);

					prev = temp;
				}
			}
		}

		return dp[m];
	}
	public static void main(String[] args) {
		int n = 3, m = 1;
		System.out.println(eulerian(n, m));
	}
}
