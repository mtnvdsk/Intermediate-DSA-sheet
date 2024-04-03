//recursion
class Solution {
    void rec(int i,int n,long[] ans,String temp){
        if(i==n){
            //System.out.println(temp);
            ans[0]++;
            return;
        }
        if(temp.isEmpty()){
            rec(i+1,n,ans,temp+'0');
            rec(i+1,n,ans,temp+'1');
        }
        else if(temp.charAt(temp.length()-1)=='1'){
            rec(i+1,n,ans,temp+'0');
        }
        else{
            rec(i+1,n,ans,temp+'1');
            rec(i+1,n,ans,temp+'0');
        }
    }
    long countStrings(int n) {
        long[] ans=new long[1];
        rec(0,n,ans,"");
        return ans[0];
    }
}

//memoization
class Solution {
    static final int mod = (int) 1e9 + 7;

    private long solve(int places, int val, int[][] dp) {
        if (places == 1) {
            return 1;
        }

        if (dp[places][val] != -1) return dp[places][val];

        long count = 0;
        if (val == 1) {
            count += solve(places - 1, 0, dp) % mod;
        } else if (val == 0) {
            count += solve(places - 1, 1, dp) % mod;
            count += solve(places - 1, 0, dp) % mod;
        }

        return dp[places][val] = (int) (count % mod);
    }

    public long countStrings(int n) {
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = (solve(n, 0, dp) % mod + solve(n, 1, dp) % mod) % mod;
        return ans;
    }
}

//tabulation
class Solution {
    long countStrings(int n) {
        if( n == 0 || n == 1){
            return n+1;
        }
        
        long dp[] = new long[n+1];
        dp[0] = 1;  dp[1] = 2;
        
        for( int i = 2; i<n+1; i++ ){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007; 
            
        }
        
        return dp[n];
        
    }
}