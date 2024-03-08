import java.io.*;

class Solution
{
public static int[] minDistPersons(String persons)
{
	int N = persons.length();
	int entered = 0;
	int result[] = new int[2];
	result[1] = N;
	for (int i = 0; i < N; i++) {
		
	if (persons.charAt(i) == '1')
		entered++;
	else entered--;
	
	result[0] = Math.max(result[0],entered);
	
	if(entered<0)
	{
		entered=0;
		result[0]++;
	}
	
	}

	return result;
}
public static void main(String[] args)
{
	String persons = "10101";
	int ans[] = minDistPersons(persons);
	System.out.println("Minimum Persons: " + ans[0]);
	System.out.print("Maximum Persons: " + ans[1]);
}
}
