import java.io.*;
class Gold {
static int collectGold(int[][] gold, int x, int y,
						int n, int m, int[][] dp)
{
	if ((x < 0) || (x == n) || (y == m)) {
	return 0;
	}

	if (dp[x][y] != -1) {
	return dp[x][y];
	}
	int rightUpperDiagonal= collectGold(gold, x - 1, y + 1, n, m, dp);
	int right = collectGold(gold, x, y + 1, n, m, dp);
	int rightLowerDiagonal	= collectGold(gold, x + 1, y + 1, n, m, dp);
	return dp[x][y] = gold[x][y]+ Math.max(Math.max(rightUpperDiagonal,rightLowerDiagonal),right);
}
static int getMaxGold(int[][] gold, int n, int m)
{
	int maxGold = 0;
	int[][] dp = new int[n][m];
	for (int row = 0; row < n; row++) {
	Arrays.fill(dp[row], -1);
	}
	for (int i = 0; i < n; i++) {
	int goldCollected
		= collectGold(gold, i, 0, n, m, dp);
	maxGold = Math.max(maxGold, goldCollected);
	}

	return maxGold;
}
public static void main(String[] args)
{
	int[][] gold = { { 1, 3, 1, 5 },
					{ 2, 2, 4, 1 },
					{ 5, 0, 2, 3 },
					{ 0, 6, 1, 2 } };
	int m = 4, n = 4;
	System.out.println(getMaxGold(gold, n, m));
}
}