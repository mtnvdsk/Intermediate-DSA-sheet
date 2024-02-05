public class Solution 
{ 
    static void rearrange(int[] arr, int n) 
    { 
        int temp[] = arr.clone();
        int small = 0, large = n - 1; 
        boolean flag = true; 
        for (int i = 0; i < n; i++) { 
            if (flag) 
                arr[i] = temp[large--]; 
            else
                arr[i] = temp[small++]; 
  
            flag = !flag; 
        } 
    }
}