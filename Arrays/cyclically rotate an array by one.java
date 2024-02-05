public class Test {
    static int arr[] = new int[] { 1, 2, 3, 4, 5 };
 
    static void rotate()
    {
        int i = 0, j = arr.length - 1;
        while (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }
}