import java.util.Arrays;

public class BoxStacking {
	static class Box implements Comparable<Box> {
		int length;
		int width;
		int height;

		public Box(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}

		public int compareTo(Box b) {
			return Integer.compare(this.length * this.width, b.length * b.width);
		}
	}

	public static int maxStackHeight(int[] length, int[] width, int[] height) {
		int n = length.length;
		Box[] boxes = new Box[3 * n];

		int k = 0;
		for (int i = 0; i < n; i++) {
			boxes[k++] = new Box(length[i], width[i], height[i]);
			boxes[k++] = new Box(width[i], height[i], length[i]);
			boxes[k++] = new Box(height[i], length[i], width[i]);
		}

		Arrays.sort(boxes);

		int[] dp = new int[3 * n];
		int maxHeight = 0;

		for (int i = k - 1; i >= 0; i--) {
			dp[i] = boxes[i].height;
			for (int j = i + 1; j < k; j++) {
				if (boxes[i].length < boxes[j].length
						&& boxes[i].width < boxes[j].width) {
					dp[i] = Math.max(dp[i], boxes[i].height + dp[j]);
				}
			}

			maxHeight = Math.max(maxHeight, dp[i]);
		}

		return maxHeight;
	}

	public static void main(String[] args) {
		int[] length = { 4, 1, 4, 10 };
		int[] width = { 6, 2, 5, 12 };
		int[] height = { 7, 3, 6, 32 };

		System.out.println("The maximum possible height of stack is "
				+ maxStackHeight(length, width, height));
	}
}