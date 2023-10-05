class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) return false;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int dist = stones[i] - stones[j];
                if (dist > j + 1) break;
                dp[dist][i] = dp[dist - 1][j] || dp[dist][j] || dp[dist + 1][j];
                if (i == n - 1 && dp[dist][i]) {
                    return true;
                }
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
          



dp[j][i]: can the frog arrive to the i-th stone by jumping j units
        
dp[n][k] can the frog reach to the n-th stone position(idx of int[] stones) by jumping k units


stones[1] = 1      WIF_currentjump_k = stones[1] - stones[0] = 1  // jump from stones[0]
                        =>  1 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 0 || 1 || 2

                    dp[1][1] <= dp[0][0] || dp[0][1] || dp[0][2]


stones[2] = 3      WIF_currentjump_k = stones[2] - stones[1] = 2  // jump from stones[1]
                        =>  2 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 3 || 2 || 1
                    
                    dp[2][2] <= dp[1][3] || dp[1][2] || dp[1][1]


the maximum units can jump       1 -> 2 -> 3 -> 4 -> 5 ->

    ->1 ->2   ->3     ->4             ->5               ->6
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
      ^   ^     ^       ^              ^                 ^
    0 1   2     3       4              5                 6
    
    
    

dp[j][i]: can the frog arrive to the i-th stone by jumping j units

index:              0   1   2   3   4   5   6   7    
stone position:   | 0 | 1 | 3 | 5 | 6 | 8 | 12| 17|
                ------------------------------------
next jump:      0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 
                1 | 0 | 1 | 0 | 0 | 1 | 0 | 0 | 0 |
                2 | 0 | 0 | 1 | 1 | 0 | 1 | 0 | 0 |
                3 | 0 | 0 | 0 | 0 | 1 | 1 | 0 | 0 |
                4 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 0 |
                5 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
                6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
                7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

                
*/