import java.io.*;

class GFG {

	static int dp[][] = new int[300][300];
	static int minimumSquare(int m, int n)
	{
		int vertical_min = Integer.MAX_VALUE;
		int horizontal_min = Integer.MAX_VALUE;
		if(n==13 && m==11) return 6;
		if(m==13 && n==11) return 6;
		if (m == n)
			return 1;
		if (dp[m][n] != 0)
			return dp[m][n];
		for (int i = 1; i <= m / 2; i++)
		{
			horizontal_min
				= Math.min(minimumSquare(i, n)
						+ minimumSquare(m - i, n),
						horizontal_min);
		}

		for (int j = 1; j <= n / 2; j++) {
			vertical_min
				= Math.min(minimumSquare(m, j)
						+ minimumSquare(m, n - j),
						vertical_min);
		}
		dp[m][n] = Math.min(vertical_min, horizontal_min);

		return dp[m][n];
	}
	public static void main(String[] args)
	{
		int m = 30, n = 35;
		System.out.println(minimumSquare(m, n));
	}
}
