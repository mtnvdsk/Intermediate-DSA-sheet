import java.util.*;
class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] Rearrange (int arr[], int n) {
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            if(arr[i]!=-1){
                ans[arr[i]]=arr[i];
            }
        }
        return ans;
    }
}

