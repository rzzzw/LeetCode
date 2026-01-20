class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
To reach cell (i, j):
    must come from top (i-1, j)
    or from left (i, j-1)

There are no other ways.


DP definition/state:  dp[i][j] = number of unique paths to reach cell (i, j)
DP transition:        dp[i][j] = dp[i-1][j] + dp[i][j-1]
Base cases:
    First row
       - Can only move right
            dp[0][j] = 1     //How could you have arrived at (0, j)?                   
    First column
       - Can only move down
            dp[i][0] = 1

// Full DP table solution
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // base cases
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // fill dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

 */

/*
1D DP
each row only depends on: 
    - current row
    - previous row
So can compress to 1D DP

Optimized DP definition: dp[j] = number of paths to current cell in column j
DP Transition: dp[j] = dp[j] (from top) + dp[j-1] (from left)

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

**/