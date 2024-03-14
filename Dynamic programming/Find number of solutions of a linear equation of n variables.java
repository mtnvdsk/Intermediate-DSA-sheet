import java.util.Arrays;

class Solution
{
	static int countSol(int coeff[], 
						int n, int rhs)
	{
		int dp[] = new int[rhs + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for (int i = 0; i < n; i++)
		for (int j = coeff[i]; j <= rhs; j++)
			dp[j] += dp[j - coeff[i]];
	
		return dp[rhs];
	}
	public static void main (String[] args)
	{
		int coeff[] = {2, 2, 5};
		int rhs = 4;
		int n = coeff.length;
		System.out.print(countSol(coeff, n, rhs));
	}
}