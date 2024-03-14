import java.util.*;
public class Solution
{
public static int numberOfPointInPath(String path)
{
	int N = path.length();
	TreeMap<Character, Integer> dirMap
	= new TreeMap<Character, Integer>();
	int points = 1;
	dirMap.put('L', 0);
	dirMap.put('R', 0);
	dirMap.put('D', 0);
	dirMap.put('U', 0);
	for (int i = 0; i < N; i++) {Dir
	// variable
	char curDir = path.charAt(i);
	dirMap.put(curDir, 1);
	if ((dirMap.get('L') == 1
		&& dirMap.get('R') == 1)
		|| (dirMap.get('U') == 1
			&& dirMap.get('D') == 1)) {
		dirMap.put('L', 0);
		dirMap.put('R', 0);
		dirMap.put('D', 0);
		dirMap.put('U', 0);
		points++;
		dirMap.put(curDir, 1);
	}
	}
	return (points + 1);
}
public static void main(String[] args)
{
	String path = "LLUUULLDD";
	System.out.print(numberOfPointInPath(path));
	System.out.print("\n");
}
}
