import java.util.*;
class lics {
	static int LongIncrConseqSubseq(int arr[], int n)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(arr[0], 1);
		for (int i = 1; i < n; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], map.get(arr[i] - 1) + 1);
				map.remove(arr[i] - 1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		return Collections.max(map.values());
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println(LongIncrConseqSubseq(arr, n));
	}
}
