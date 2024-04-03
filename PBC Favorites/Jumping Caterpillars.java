class GFG
{
    long uneatenLeaves(long arr[], int n,int k)
    {
        // Your code goes here   
        int leaves[] = new int[n];
        long ans = n;
        for(int i=0;i<k;++i) {
            int jump = (int) arr[i];
            for(int j=jump;j<=n;j+=jump) {
                if(leaves[j-1] == 0) {
                    leaves[j-1] = -1;
                    --ans;
                }
            }
        }
        return ans;
    }
}