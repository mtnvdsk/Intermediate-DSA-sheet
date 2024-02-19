import java.util.*;
import java.io.*;

class Solution {
	public static boolean increasing(int a[],int n)
	{
		for (int i = 0; i < n - 1; i++) 
			if (a[i] >= a[i + 1])
				return false; 
				
		return true;
	}
	public static boolean decreasing(int arr[],int n)
	{
		for (int i = 0; i < n - 1; i++) 
			if (arr[i] < arr[i + 1])
				return false; 
				
		return true;
	}
	
	public static int shortestUnsorted(int a[],int n)
	{
		if (increasing(a, n) == true || 
							decreasing(a, n) == true)
			return 0;
		else
			return 3;
	}
	public static void main (String[] args) {
		
		int ar[] = new int[]{7, 9, 10, 8, 11};
		int n = ar.length;
		
		System.out.println(shortestUnsorted(ar,n));
	}
}
