import java.util.HashSet;
public class GameOfReplacingArrayElements 
{ 
	public static int playGame(int arr[])
	{
		HashSet<Integer> set=new HashSet<>();
		for(int i:arr)
			set.add(i);
		return (set.size()%2==0)?1:2;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 1, 2, 2, 2, 2 }; 
		System.out.print("Player "+playGame(arr)+" wins");
	}
}