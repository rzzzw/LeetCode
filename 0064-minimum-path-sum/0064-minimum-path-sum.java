// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] dp = new int[m][n];

//         // Base case: start cell
//         dp[0][0] = grid[0][0];

//         // First row. =>  How could you have arrived at (0, j)? <- first row, can only from (0, j - 1)
//         for (int j = 1; j < n; j++) {
//             dp[0][j] = dp[0][j - 1] + grid[0][j];
//         }

//         // First column
//         for (int i = 1; i < m; i++) {
//             dp[i][0] = dp[i - 1][0] + grid[i][0];
//         }

//         // Fill the rest
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];
    }
}

/**
To reach cell (i, j):
    You must come from:
        - (i-1, j) (up)
        - (i, j-1) (left)
The minimum path to (i, j) depends on minimum paths to those two cells.

Define DP state: dp[i][j] = minimum path sum to reach cell (i, j)
DP transition: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])

 */