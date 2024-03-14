class Solution 
{ 
    int palindromeSubStrs(String str) { 
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        HashSet<String> set = new HashSet<>();
        
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) {
                if(gap == 0)
                    dp[i][j] = true;
                else if(gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = true;
                else
                    dp[i][j] = (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]);
                    
                if(dp[i][j])
                    set.add(str.substring(i, j + 1));
            }
        }
        return set.size();
    }
}