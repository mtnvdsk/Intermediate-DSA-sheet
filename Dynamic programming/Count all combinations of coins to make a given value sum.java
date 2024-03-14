import java.util.*;

class Solution {
	static int count(int[] coins, int sum, int n,
					int[][] dp)
	{
		if (sum == 0)
			return dp[n][sum] = 1;
		if (n == 0 || sum<0)
			return 0;
		if (dp[n][sum] != -1)
			return dp[n][sum];
		return dp[n][sum]
			= count(coins, sum - coins[n - 1], n, dp)
			+ count(coins, sum, n - 1, dp);
	}
	public static void main(String[] args)
	{
		int tc = 1;
		while (tc != 0) {
			int n, sum;
			n = 3;
			sum = 5;
			int[] coins = { 1, 2, 3 };
			int[][] dp = new int[n + 1][sum + 1];
			for (int[] row : dp)
				Arrays.fill(row, -1);
			int res = count(coins, sum, n, dp);
			System.out.println(res);
			tc--;
		}
	}
}
