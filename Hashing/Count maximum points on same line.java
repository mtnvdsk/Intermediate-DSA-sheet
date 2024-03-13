import java.util.*;

class Solution {
	static int gcd(int p, int q)
	{
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}

	static int N = 6;

	// method to find maximum collinear point
	static int maxPointOnSameLine(int[][] points)
	{
		if (N < 2)
			return N;
		int maxPoint = 0;
		int curMax, overlapPoints, verticalPoints;

		HashMap<String, Integer> slopeMap = new HashMap<>();
		// looping for each point
		for (int i = 0; i < N; i++) {
			curMax = overlapPoints = verticalPoints = 0;

			// looping from i + 1 to ignore same pair again
			for (int j = i + 1; j < N; j++) {
				// If both point are equal then just
				// increase overlapPoint count
				if (points[i][0] == points[j][0]
					&& points[i][1] == points[j][1])
					overlapPoints++;

				// If x co-ordinate is same, then both
				// point are vertical to each other
				else if (points[i][0] == points[j][0])
					verticalPoints++;

				else {
					int yDif = points[j][1] - points[i][1];
					int xDif = points[j][0] - points[i][0];
					int g = gcd(xDif, yDif);

					// reducing the difference by their gcd
					yDif /= g;
					xDif /= g;

					// Convert the pair into a string to use
					// as dictionary key
					String pair = (yDif) + " " + (xDif);
					if (!slopeMap.containsKey(pair))
						slopeMap.put(pair, 0);

					// increasing the frequency of current
					// slope in map
					slopeMap.put(pair,
								slopeMap.get(pair) + 1);
					curMax = Math.max(curMax,
									slopeMap.get(pair));
				}

				curMax = Math.max(curMax, verticalPoints);
			}

			// updating global maximum by current point's
			// maximum
			maxPoint = Math.max(maxPoint,
								curMax + overlapPoints + 1);
			slopeMap.clear();
		}

		return maxPoint;
	}

	public static void main(String[] args)
	{
		int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 },
						{ 2, 2 }, { 3, 3 }, { 3, 4 } };
		System.out.println(maxPointOnSameLine(points));
	}
}
