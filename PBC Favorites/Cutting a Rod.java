class HelloWorld {
    public static int rec(int []a,int i,int n){
        if(i==0){
            return n*a[0];
        }
        int nocut=rec(a,i-1,n);
        int cut=Integer.MIN_VALUE;
        int rodlength=i+1;
        if(rodlength<=n){
            cut=a[i]+rec(a,i,n-rodlength);
        }
        return Math.max(cut,nocut);
    }
    public static void main(String[] args) {
        int a[]={1, 5, 8, 9, 10, 17, 17, 20};
        int n=a.length;
        int ans=rec(a,n-1,n);
        System.out.println(ans);
    }
}



import java.io.*;
import java.util.*;
class Solution {
private static int cutRod(int price[], int index, int n,
							int[][] dp)
{
	if (index == 0) {
	return n * price[0];
	}

	if (dp[index][n] != -1) {
	return dp[index][n];
	}
	int notCut = cutRod(price, index - 1, n, dp);
	int cut = Integer.MIN_VALUE;
	int rod_length = index + 1;

	if (rod_length <= n) {
	cut = price[index]
		+ cutRod(price, index, n - rod_length,
				dp);
	}

	return dp[index][n] = Math.max(cut, notCut);
}
public static void main(String[] args)
{
	int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
	int size = arr.length;
	int dp[][] = new int[size][size + 1];
	for (int i = 0; i < size; i++) {
	Arrays.fill(dp[i], -1);
	}
	System.out.println(
	"Maximum Obtainable Value is "
	+ cutRod(arr, size - 1, size, dp));
}
}


