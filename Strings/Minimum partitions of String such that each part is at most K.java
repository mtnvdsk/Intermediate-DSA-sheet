// JAVA program for above implementation
import java.util.*;
class Solution {
	public static int minimumCommas(String s, int k)
	{
		int n = s.length();
		long cur = 0;
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (cur * 10
					+ Character.getNumericValue(s.charAt(i))
				<= k) {
				cur = cur * 10
					+ Character.getNumericValue(
						s.charAt(i));
			}
			else {
				if (cur == 0 || cur > k) {
					return -1;
				}
				else {
					ans++;
					cur = Character.getNumericValue(
						s.charAt(i));
				}
			}
		}
		if (cur > 0 && cur <= k) {
			ans++;
		}
		return ans - 1;
	}
	public static void main(String[] args)
	{
		String S = "7891634";
		int K = 21;
		System.out.print(minimumCommas(S, K));
	}
}