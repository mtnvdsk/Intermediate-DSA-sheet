class HelloWorld {
    public static int rec(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= n; j++)
            dp[0][j] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (arr[j - 1] <= i && arr[j - 1] > 0)
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
            }
        }
        return dp[k][n];
    }
    public static void main(String[] args) {
        int[] a={4,8,7,2};
        int k=50;
        System.out.println(rec(a,k));
    }
}