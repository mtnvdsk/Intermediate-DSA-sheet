import java.io.*;
import java.util.*;

class Solution
{
	static boolean checkbit(int array[], int index) 
	{ 
			int val = array[index >> 5] & (1 << (index & 31));
			if (val == 0)
				return false;
			return true; 
	} 
	static void setbit(int array[], int index) 
	{ 
			array[index >> 5] |= (1 << (index & 31)); 
	}
	public static void main(String args[])
	{
			int a = 2, b = 10; 
			int size = Math.abs(b-a);
			size = (int)Math.ceil((double)size / 32);
			int[] array = new int[size];
			for (int i = a; i <= b; i++) 
				if (i % 2 == 0 || i % 5 == 0) 
					setbit(array, i - a);

			System.out.println("MULTIPLES of 2 and 5:");
			for (int i = a; i <= b; i++) 
				if (checkbit(array, i - a)) 
					System.out.print(i + " "); 
	}
}
