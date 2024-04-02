class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int k){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(candies);
        int max=0,min=0,free=0;
        for(int i=0;i<N-free;i++){
            min+=candies[i];
            free+=k;
        }
        free=0;
        for(int i=N-1;i>=free;i--){
            max+=candies[i];
            free+=k;
        }
        ans.add(min);
        ans.add(max);
        return ans;
    }
}