class Solution {
	static int maxLen(int arr[], int N)
	{
		int max_len = 0;
		for (int i = 0; i < N; i++) {
			int curr_sum = 0;
			for (int j = i; j < N; j++) {
				curr_sum += arr[j];
				if (curr_sum == 0)
					max_len = Math.max(max_len, j - i + 1);
			}
		}
		return max_len;
	}
	public static void main(String args[])
	{
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		int N = arr.length;
		System.out.println("Length of the longest 0 sum "
						+ "subarray is " + maxLen(arr, N));
	}
}
