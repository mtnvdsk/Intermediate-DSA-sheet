class Solution {
	static void printArr(int[] arr, int k)
	{
		for (int i = 0; i < k; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\n");
	}
	static void printSeqUtil(int n, int k, 
							int len, int[] arr)
	{
		if (len == k)
		{
			printArr(arr, k);
			return;
		}
		int i = (len == 0) ? 1 : arr[len - 1] + 1;
		len++;
		while (i <= n)
		{
			arr[len - 1] = i;
			printSeqUtil(n, k, len, arr);
			i++;
		}
		len--;
	}
	static void printSeq(int n, int k)
	{
		int[] arr = new int[k];
		int len = 0; 
		printSeqUtil(n, k, len, arr);
	}
	static public void main (String[] args)
	{
		int k = 3, n = 7;
		printSeq(n, k);
	}
}
