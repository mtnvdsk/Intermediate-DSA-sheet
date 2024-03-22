class Solution {

	static final int R = 3;
	static final int C = 3;
	static final int MAX_K = 100;

	static int[][][] dp = new int[R][C][MAX_K];

	static int pathCountDPRecDP(int[][] mat, int m, int n,
								int k)
	{
		if (m < 0 || n < 0 || k < 0)
			return 0;
		if (m == 0 && n == 0)
			return (k == mat[m][n] ? 1 : 0);
		if (dp[m][n][k] != -1)
			return dp[m][n][k];
		dp[m][n][k]
			= pathCountDPRecDP(mat, m - 1, n, k - mat[m][n])
			+ pathCountDPRecDP(mat, m, n - 1,
								k - mat[m][n]);

		return dp[m][n][k];
	}
	static int pathCountDP(int[][] mat, int k)
	{
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				for (int l = 0; l < MAX_K; l++)
					dp[i][j][l] = -1;

		return pathCountDPRecDP(mat, R - 1, C - 1, k);
	}
	public static void main(String[] args)
	{
		int k = 12;
		int[][] mat = new int[][] { new int[] { 1, 2, 3 },
									new int[] { 4, 6, 5 },
									new int[] { 3, 2, 1 } };

		System.out.println(pathCountDP(mat, k));
	}
}
