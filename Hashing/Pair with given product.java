import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 9, 40 };
		int n = arr.length;

		int x = 400;
		// Test case 1
		if (isProduct(arr, n, x)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		x = 190;
		// Test case 2
		if (isProduct(arr, n, x)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	static boolean isProduct(int[] arr, int n, int x) {
		Arrays.sort(arr);

		int l = 0, r = n - 1;
		while (l < r) {
			int prod = arr[l] * arr[r];
			if (prod == x) {
				return true;
			}
			else if (prod < x) {
				l++;
			}
			else {
				r--;
			}
		}

		return false;
	}
}
