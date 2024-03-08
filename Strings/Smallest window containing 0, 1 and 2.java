import java.util.*;
class Solution {
	public static int smallestSubstring(String S)
	{
		int res = Integer.MAX_VALUE;
		boolean zero = false, one = false, two = false;
		int zeroindex = 0, oneindex = 0, twoindex = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '0') {
				zero = true;
				zeroindex = i;
			}
			else if (S.charAt(i) == '1') {
				one = true;
				oneindex = i;
			}
			else if (S.charAt(i) == '2') {
				two = true;
				twoindex = i;
			}
			if (zero && one && two)
				res = Math.min( res,
					Math.max(zeroindex,Math.max(oneindex, twoindex))
				- Math.min( zeroindex,Math.min(oneindex, twoindex)));
		}
		if (res == Integer.MAX_VALUE)
			return -1;
		return res + 1;
	}
	public static void main(String[] args)
	{
		String S = "01212";
		// Function call
		System.out.print(smallestSubstring(S));
	}
}