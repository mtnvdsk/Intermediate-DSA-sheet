import java.util.*; 

class Main { 
public static void main(String[] args) 
{ 
	int[] primes = { 2, 5 }; 
	int k = primes.length; 
	int n = 5; 
	System.out.println(superUgly(n, primes, k)); 
} 
public static int superUgly(int n, int[] primes, int k) 
{  
	int[] nextMultiple = Arrays.copyOf(primes, k); 
	int[] multiple_Of = new int[k]; 
	Arrays.fill(multiple_Of, 0); 
	Set<Integer> ugly = new HashSet<>(); 
	ugly.add(1);
	while (ugly.size() != n) {
	int next_ugly_no = Integer.MAX_VALUE; 
	for (int i = 0; i < k; i++) { 
		next_ugly_no = Math.min(next_ugly_no,nextMultiple[i]); 
	}
	ugly.add(next_ugly_no);
	for (int j = 0; j < k; j++) { 
		if (next_ugly_no == nextMultiple[j]) {
		multiple_Of[j]++; 
		List<Integer> uglyList = new ArrayList<>(ugly); 
		int it = uglyList.get(multiple_Of[j] - 1); 
		nextMultiple[j] = primes[j] * it; 
		break; 
		} 
	} 
	}
	List<Integer> uglyList = new ArrayList<>(ugly); 
	return uglyList.get(uglyList.size() - 1); 
} 
}