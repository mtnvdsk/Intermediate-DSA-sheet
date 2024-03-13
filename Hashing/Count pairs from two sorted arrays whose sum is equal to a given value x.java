import java.io.*;
class Solution {
static boolean isPresent(int arr[], int low,
						int high, int value)
{
	while (low <= high)
	{
		int mid = (low + high) / 2;
		if (arr[mid] == value)
			return true;	 
			
		else if (arr[mid] > value) 
			high = mid - 1;
		else
			low = mid + 1; 
	}
	return false;
}
static int countPairs(int arr1[], int arr2[],
					int m, int n, int x)
{
	int count = 0; 
	for (int i = 0; i < m; i++)
	{
		int value = x - arr1[i];
		if (isPresent(arr2, 0, n - 1, value))
			count++;
	}
	return count;
}
	public static void main (String[] args) 
	{
		int arr1[] = {1, 3, 5, 7};
		int arr2[] = {2, 3, 5, 8};
		int m = arr1.length;
		int n = arr2.length;
		int x = 10;
		System.out.println("Count = "
			+ countPairs(arr1, arr2, m, n, x));
	}
}
