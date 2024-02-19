import java.util.Arrays;

class FindSmallestInteger 
{
	int findSmallest(int arr[], int n) 
	{
		int res = 1;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
		{
		if(arr[i] > res){
			return res;
		}
		else{
			res+=arr[i];
		}
		}
			
		return res;
	}
	public static void main(String[] args) 
	{
		FindSmallestInteger small = new FindSmallestInteger();
		int arr1[] = {1, 3, 4, 5};
		int n1 = arr1.length;
		System.out.println(small.findSmallest(arr1, n1));

		int arr2[] = {1, 2, 6, 10, 11, 15};
		int n2 = arr2.length;
		System.out.println(small.findSmallest(arr2, n2));

		int arr3[] = {1, 1, 1, 1};
		int n3 = arr3.length;
		System.out.println(small.findSmallest(arr3, n3));

		int arr4[] = {1, 1, 3, 4};
		int n4 = arr4.length;
		System.out.println(small.findSmallest(arr4, n4));

	}
}


//solution2
import java.util.ArrayList;

public class GFG {
	public static int smallestPositiveInteger(ArrayList<Integer> arr) {
		int n = arr.size();
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += arr.get(i); // compute sum of all elements
		}
		boolean[] dp = new boolean[s + 1]; // initialize dp array with false values
		dp[0] = true; // a subset with sum 0 can always be formed
		for (int i = 0; i < n; i++) {
			for (int j = s; j >= arr.get(i); j--) {
				if (dp[j - arr.get(i)]) { // if it's possible to form a subset with sum j-arr[i]
					dp[j] = true; // then it's also possible to form a subset with sum j
				}
			}
		}
		for (int i = 1; i <= s; i++) {
			if (!dp[i]) { // find the smallest positive integer that cannot be formed
				return i;
			}
		}
		return s + 1; // if all integers can be formed, then the answer is s+1
	}

	// Driver code
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		System.out.println(smallestPositiveInteger(arr));

		arr.clear();
		arr.add(1);
		arr.add(2);
		arr.add(6);
		arr.add(10);
		arr.add(11);
		arr.add(15);
		System.out.println(smallestPositiveInteger(arr));

		arr.clear();
		arr.add(1);
		arr.add(1);
		arr.add(1);
		arr.add(1);
		System.out.println(smallestPositiveInteger(arr));

		arr.clear();
		arr.add(1);
		arr.add(1);
		arr.add(3);
		arr.add(4);
		System.out.println(smallestPositiveInteger(arr));
	}
}
