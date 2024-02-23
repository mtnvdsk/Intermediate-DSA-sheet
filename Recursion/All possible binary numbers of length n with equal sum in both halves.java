import java.util.*;

class Solution
{
static void equal(int n, String left, 
						String right, int di)
{
	if (n == 0)
	{
		if (di == 0)
			System.out.print(left + right + " ");
		return;
	}
	if (n == 1)
	{
		if (di == 0)
		{
			System.out.print(left + "0" + right + " ");
			System.out.print(left + "1" + right + " ");
		}
		return;
	}
	if ((2 * Math.abs(di) <= n))
	{
		equal(n - 2, left + "0", right + "0", di);
		equal(n - 2, left + "0", right + "1", di - 1);
		equal(n - 2, left + "1", right + "0", di + 1);
		equal(n - 2, left + "1", right + "1", di);
	}
}

public static void main(String args[])
{
	int n = 5; 
	equal(n, "", "", 0);
}
}
