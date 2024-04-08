import java.io.*; 
import java.util.*; 

class GFG { 
	static void alternateSubarray(boolean arr[], int n) 
	{
		int count = 1; 
		boolean prev = arr[0]; 
		for (int i = 1; i < n; ++i) { 
			if ((arr[i] ^ prev) == false) {
				while (count > 0) { 
					System.out.print(count-- + " "); 
				} 
			} 
			++count; 
			prev = arr[i]; 
		} 
		while (count != 0) { 
			System.out.print(count-- + " "); 
		} 
	} 
	public static void main(String args[]) 
	{ 
		boolean arr[] 
			= { true, false, true, false, false, true }; 
		int n = arr.length; 
		alternateSubarray(arr, n); 
	} 
}
