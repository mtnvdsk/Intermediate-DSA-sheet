class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
      
        int c=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if((m+i)<=n){
                int b=a.get((m+i)-1)-a.get(i);
                c=Math.min(c,b);
            }
            else{
                break;
            }
        }
        return c;
    }
}