class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
               //j * (i - j) 
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}


/**

    2: 1+1  => 1
    3: 1+2  => 2 or 1 => 2
    4: 1 3  => 3 or 2 
       2 2  => 4 or 1 => 4
    5: 1 4  => 4
       2 3  => 6 or 4 => 6
    6: 1 5  => 5 or 6
       2 4  => 8 or 8
       3 3  => 9 or 6 or 4

       

 */