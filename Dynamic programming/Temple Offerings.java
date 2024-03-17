import java.util.*;

class Solution {
	public static class Temple {
		public int L;
		public int R;
	};
	static int offeringNumber(int n, int[] templeHeight)
	{
		Temple[] chainSize = new Temple[n];

		for (int i = 0; i < n; ++i) {
			chainSize[i] = new Temple();
			chainSize[i].L = -1;
			chainSize[i].R = -1;
		}

		chainSize[0].L = 1;
		chainSize[n - 1].R = 1;
		for (int i = 1; i < n; ++i) {
			if (templeHeight[i - 1] < templeHeight[i])
				chainSize[i].L = chainSize[i - 1].L + 1;
			else
				chainSize[i].L = 1;
		}

		for (int i = n - 2; i >= 0; --i) {
			if (templeHeight[i + 1] < templeHeight[i])
				chainSize[i].R = chainSize[i + 1].R + 1;
			else
				chainSize[i].R = 1;
		}
		int sum = 0;
		for (int i = 0; i < n; ++i)
			sum += Math.max(chainSize[i].L, chainSize[i].R);

		return sum;
	}
	public static void main(String[] s)
	{
		int[] arr1 = { 1, 2, 2 };
		System.out.println(offeringNumber(3, arr1));

		int[] arr2 = { 1, 4, 3, 6, 2, 1 };
		System.out.println(offeringNumber(6, arr2));
	}
}