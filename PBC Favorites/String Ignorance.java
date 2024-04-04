
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int i = 0;
		String[] str = new String[n];
		while(i < n) {
		    str[i] = sc.nextLine();
		    i++;
		}
		
		for(String s: str) {
		    HashMap<Character, Integer> map = new HashMap<>();
		    for(char ch: s.toCharArray()) {
		        char lowerch = Character.toLowerCase(ch);
		        if(map.getOrDefault(lowerch, 0) % 2 == 0) {
		            System.out.print(ch);
		        }
		        map.put(lowerch , map.getOrDefault(lowerch, 0) + 1);
		    }
		    System.out.println();
		}
		
}
}