class Solution{
    long nCr(int n, int r, int MOD) {
       long numerator = 1;
       long denominator = 1;

       for(int i = 0; i < r; i++) {
           numerator = (numerator * (n - i)) % MOD;
           denominator = (denominator * (i + 1)) % MOD;
       }

       long ncr = (numerator * modInverse(denominator, MOD)) % MOD;
       return ncr;
   }

   long modInverse(long base, int MOD) {
       return modPower(base, MOD - 2, MOD);
   }

   long modPower(long base, int exponent, int MOD) {
       long pow = 1;

       while(exponent > 0) {
           if(exponent % 2 == 1) {
               pow = (pow * base) % MOD;
           }

           base = (base * base) % MOD;
           exponent /= 2;
       }
       return pow;
   }
   long numberOfPaths(int M, int N) {
       int MOD = (int)1e9 + 7;

       int n = M + N - 2;
       int r = Math.min(M - 1, N - 1);

       return nCr(n, r, MOD);
   }
}

//dp
import java.util.Arrays;

class Solution{
    long countPaths(int i, int j, int M, int N, long[][] dp) {
        int MOD = (int)1e9 + 7;
        if(i == M - 1 && j == N - 1) {
            return 1;
        }
        if(i >= M || j >= N) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        dp[i][j] = (countPaths(i + 1, j, M, N, dp) % MOD + countPaths(i, j + 1, M, N, dp) % MOD) % MOD;
        return dp[i][j];
    }
    
    long numberOfPaths(int M, int N) {
        int MOD = 1000000007;
        long[][] dp = new long[M][N];
        
        // Initialize the dp array with -1
        for(int i = 0; i < M; i++)
            Arrays.fill(dp[i], -1);
        
        return countPaths(0, 0, M, N, dp);
    }
}
