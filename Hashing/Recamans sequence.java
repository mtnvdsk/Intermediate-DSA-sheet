import java.io.*;

class Solution {
	static void recaman(int n)
	{
		int arr[] = new int[n];
		arr[0] = 0;
		System.out.print(arr[0]+" ,");
		for (int i = 1; i < n; i++)
		{
			int curr = arr[i - 1] - i;
			int j;
			for (j = 0; j < i; j++)
			{
				if ((arr[j] == curr) || curr < 0)
				{
					curr = arr[i - 1] + i;
					break;
				}
			}
	
			arr[i] = curr;
			System.out.print(arr[i]+", ");
			
		}
	}
	public static void main (String[] args) 
	{
		int n = 17;
		recaman(n);

	}
}