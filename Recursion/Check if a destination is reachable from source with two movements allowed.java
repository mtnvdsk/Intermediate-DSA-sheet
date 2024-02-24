class Solution {
	
	static boolean isReachable(int sx, int sy,
								int dx, int dy)
	{
		if (sx > dx || sy > dy)
			return false;
		if (sx == dx && sy == dy)
			return true;
		return (isReachable(sx + sy, sy, dx, dy) || 
				isReachable(sx, sy + sx, dx, dy));
	}
	public static void main(String arg[])
	{
		int source_x = 2, source_y = 10;
		int dest_x = 26, dest_y = 12;
		if (isReachable(source_x, source_y, dest_x,
										dest_y))
			System.out.print("True\n");
		else
			System.out.print("False\n");
	}
}
