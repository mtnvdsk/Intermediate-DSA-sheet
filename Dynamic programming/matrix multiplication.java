import java.io.*;
import java.util.*;
class MatrixChainMultiplication {
	static int MatrixChainOrder(int p[], int i, int j)
	{
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = MatrixChainOrder(p, i, k)
						+ MatrixChainOrder(p, k + 1, j)
						+ p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}
		return min;
	}
	public static void main(String args[])
	{
		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		int N = arr.length;
		System.out.println(
			"Minimum number of multiplications is "
			+ MatrixChainOrder(arr, 1, N - 1));
	}
}


//dynamic programming
import java.io.*;
import java.util.*;
class GFG
{

static int[][] dp = new int[100][100];
static int matrixChainMemoised(int[] p, int i, int j) 
{ 
	if (i == j) 
	{ 
	return 0; 
	} 
	if (dp[i][j] != -1) 
	{ 
	return dp[i][j]; 
	} 
	dp[i][j] = Integer.MAX_VALUE; 
	for (int k = i; k < j; k++) 
	{ 
	dp[i][j] = Math.min( 
		dp[i][j], matrixChainMemoised(p, i, k) 
		+ matrixChainMemoised(p, k + 1, j) 
		+ p[i - 1] * p[k] * p[j]); 
	} 
	return dp[i][j]; 
} 

static int MatrixChainOrder(int[] p, int n) 
{ 
	int i = 1, j = n - 1; 
	return matrixChainMemoised(p, i, j); 
} 

public static void main (String[] args)
{

	int arr[] = { 1, 2, 3, 4 }; 
	int n= arr.length;

	for (int[] row : dp) 
	Arrays.fill(row, -1); 

	System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
}
}
