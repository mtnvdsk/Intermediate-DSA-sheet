import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Solution { 
	public static long findWays(int m, int n, int x){
	long[][] table = new long[n+1][x+1]; 
	for(int j = 1; j <= m && j <= x; j++) 
				table[1][j] = 1; 
	for(int i = 2; i <= n;i ++){ 
				for(int j = 1; j <= x; j++){ 
					for(int k = 1; k < j && k <= m; k++) 
						table[i][j] += table[i-1][j-k]; 
				} 
		}		
		return table[n][x]; 
	} 
	public static void main (String[] args) { 
		System.out.println(findWays(4, 2, 1)); 
		System.out.println(findWays(2, 2, 3)); 
		System.out.println(findWays(6, 3, 8)); 
		System.out.println(findWays(4, 2, 5)); 
		System.out.println(findWays(4, 3, 5)); 
	} 
}