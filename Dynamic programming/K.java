import java.util.*;
import java.io.*;

class GFG 
{
	static int isKPalRec(String str1, 
			String str2, int m, int n) 
	{
		if (m == 0) 
		{
			return n;
		}
		if (n == 0) 
		{
			return m;
		} 
		if (str1.charAt(m - 1) == 
			str2.charAt(n - 1))
		{
			return isKPalRec(str1, str2, 
							m - 1, n - 1);
		}
		return 1 + Math.min(isKPalRec(str1, str2, m - 1, n), 
				isKPalRec(str1, str2, m, n - 1));
	}
	static boolean isKPal(String str, int k) 
	{
		String revStr = str;
		revStr = reverse(revStr);
		int len = str.length();

		return (isKPalRec(str, revStr, len, len) <= k * 2);
	}

	static String reverse(String input) 
	{
		char[] temparray = input.toCharArray();
		int left, right = 0;
		right = temparray.length - 1;

		for (left = 0; left < right; left++, right--)
		{
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right] = temp;
		}
		return String.valueOf(temparray);
	}
	public static void main(String[] args)
	{
		String str = "acdcb";
		int k = 2;
		if (isKPal(str, k)) 
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}



import java.util.*;
import java.io.*;

class GFG 
{
	static int isKPalDP(String str1, 
			String str2, int m, int n) 
	{
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) 
		{
			for (int j = 0; j <= n; j++) 
			{
				if (i == 0) 
				{
					dp[i][j] = j; 
				} 
				else if (j == 0) 
				{
					dp[i][j] = i; 
				} 
				else if (str1.charAt(i - 1) ==
						str2.charAt(j - 1)) 
				{
					dp[i][j] = dp[i - 1][j - 1];
				} 
				else
				{
					dp[i][j] = 1 + Math.min(dp[i - 1][j], 
							dp[i][j - 1]); 
				}
			}
		}
		return dp[m][n];
	}
	static boolean isKPal(String str, int k)
	{
		String revStr = str;
		revStr = reverse(revStr);
		int len = str.length();

		return (isKPalDP(str, revStr,
				len, len) <= k * 2);
	}

	static String reverse(String str)
	{
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}
	public static void main(String[] args) 
	{
		String str = "acdcb";
		int k = 2;
		if (isKPal(str, k)) 
		{
			System.out.println("Yes");
		} 
		else
		{
			System.out.println("No");
		}
	}
}
