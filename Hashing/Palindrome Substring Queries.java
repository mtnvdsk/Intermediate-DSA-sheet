import java.util.Arrays;
import java.util.List;

public class Main {

	// A function to check if a string str is palindrome
	// in the range L to R
	public static boolean isPalindrome(String str, int L, int R) {
		// Keep comparing characters while they are same
		while (R > L) {
			if (str.charAt(L++) != str.charAt(R--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "abaaabaaaba";
		int n = str.length();

		List<List<Integer>> queries = Arrays.asList(
				Arrays.asList(0, 10),
				Arrays.asList(5, 8),
				Arrays.asList(2, 5),
				Arrays.asList(5, 9)
		);

		for (List<Integer> q : queries) {
			boolean result = isPalindrome(str, q.get(0), q.get(1));
			if (result) {
				System.out.println("The substring [" + q.get(0) + "," + q.get(1)
						+ "] is a palindrome");
			} else {
				System.out.println("The substring [" + q.get(0) + "," + q.get(1)
						+ "] is not palindrome");
			}
		}
	}
}
