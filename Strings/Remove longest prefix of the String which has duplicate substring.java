import java.io.*;

class GFG 
{
public static String delPrefix(String S)
{
	if (S.length() == 1)
	return S;
	int i = 0, maxi = 0;
	for (int j = 1; j < S.length(); j++) {
	int k = j;
	while (k < S.length()
			&& S.charAt(k) == S.charAt(i)) {
		k++;
		i++;
	}
	maxi = Math.max(maxi, i);
	i = 0;
	}
	return S.substring(maxi);
}
public static void main(String[] args)
{
	String S = "aaaaa";
	String ans = delPrefix(S);

	// Function call
	System.out.print(ans);
}
}
