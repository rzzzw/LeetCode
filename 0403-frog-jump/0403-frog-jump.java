class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        
        for (int k = 1; k < n; k++) {       // first jump = 1; assum jump k + 1 (the maximum jump) every time
            if (stones[k] - stones[k - 1] > k) return false;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) break;
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k] ) return true;
            }
        }
        return false;
    }
}

/*
          0 1   2   3 4   5         6              7
stones = [0,1,  3,  5,6,  8,        12,            17]
              --  --    --  -------    -----------
          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17

        
dp[n][k] can the frog reach to the n-th stone position(idx of int[] stones) by jumping k units


stones[1] = 1      WIF_currentjump_k = stones[1] - stones[0] = 1  // jump from stones[0]
                        =>  1 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 0 || 1 || 2

                    dp[1][1] <= dp[0][0] || dp[0][1] || dp[0][2]


stones[2] = 3      WIF_currentjump_k = stones[2] - stones[1] = 2  // jump from stones[1]
                        =>  2 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 3 || 2 || 1
                    
                    dp[2][2] <= dp[1][3] || dp[1][2] || dp[1][1]
*/