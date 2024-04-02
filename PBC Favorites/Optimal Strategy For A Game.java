class solve
{
    //Function to find the maximum possible amount of money we can win.
    public long sum(List<Integer> ans){
        long s=0;
        for(Integer i:ans){
            s+=i;
        }
        return s;
    }
    public long rec(int i,int j,int[] arr,List<Integer> ans){
        if(i>j){
            return sum(ans);
        }
        long first=rec(i+1,j,arr,ans.add(arr[i]));
        long last=rec(i,j-1,arr,ans.add(arr[j]));
        return Math.max(first,last);
    }
    static long countMaximum(int n, int arr[])
    {
        return rec(0,n-1,arr,new ArrayList<>());
    }
}