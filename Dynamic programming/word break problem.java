import java.io.*;
import java.util.*;

class Solution{

public static boolean wordBreak(String s, List<String> dictionary) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
	
		for(int i = 0; i <= s.length(); i++){
			for(int j = 0; j < i; j++){
				if(dp[j] && dictionary.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public static void main (String[] args) {
	String[] dictionary = { "mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i",
				"like", "ice",	 "cream" };

		List<String> dict = new ArrayList<>();
		for(String s : dictionary){
			dict.add(s);
		}

		if (wordBreak("ilikesamsung", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (wordBreak("iiiiiiii", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (wordBreak("", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (wordBreak("samsungandmango", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (wordBreak("ilikesamsung", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		if (wordBreak("samsungandmangok", dict)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	
	}
}
