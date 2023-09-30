class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1]; 
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}

/**

1 node => dp[1] = 1
2 nodes => dp[2] = 2
        example: a < b       b      a
                            /   or   \
                           a          b
                   
        1' left 0, right 1  => dp[0] * dp[1] = 1
        2' left 1, right 0  => dp[1] * dp[0] = 1
        ( 0 node represents null subtree => let dp[0] = 1 )
        
   dp[2] = 2     

3 nodes:
        1' left 0, right 2  => dp[0] * dp[2] = 2
        2' left 1, right 1  => dp[1] * dp[1] = 1
        3' left 2, right 0  => dp[2] * dp[0] = 2
        
   dp[3] = 5

 */