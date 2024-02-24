import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	public static List<List<Integer> >
	factorCombinations(int n)
	{
		List<List<Integer> > combinations
			= new ArrayList<>();

		backtrack(2, n, new ArrayList<>(), combinations, n);

		return combinations;
	}

	private static void
	backtrack(int start, int target, List<Integer> factors,
			List<List<Integer> > combinations, int n)
	{
		if (target == 1) {
			if (factors.size() > 1 || factors.get(0) != n) {
				combinations.add(new ArrayList<>(factors));
			}
			return;
		}
		for (int i = start; i <= target; i++) {
			if (target % i == 0) {
				factors.add(i);
				backtrack(i, target / i, factors,
						combinations, n);
				factors.remove(factors.size() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		int n = 12;
		List<List<Integer> > combinations
			= factorCombinations(n);

		System.out.printf(
			"All the combinations of factors of %d are:%n",
			n);
		for (List<Integer> combination : combinations) {
			System.out.println(combination);
		}
	}
}
