/**

This is a classic:
• DFS
• DP memoization
• on a directed acyclic graph (DAG)

Find the longest path where:
    next cell > current cell

Key Insight:
From every cell (i,j) What is the longest increasing path STARTING here?

Define:  dp(i,j)=1+max(dp(neighbor))

where:
    neighbor is valid
    and neighbor value is larger

Why This Is a DAG？
    Edges only go: smaller -> larger. You can NEVER return to a smaller value. So cycles are impossible. That makes DFS + memoization safe.
 */

// class Solution {

//     public static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//     public int longestIncreasingPath(int[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return 0;
//         }
//         int m = matrix.length;
//         int n = matrix[0].length;      

//         int[][] dp = new int[m][n];

//         int res = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 res = Math.max(res, dfs(matrix, i, j, dp));
//             }
//         }  
//         return res;
//     }

//     private int dfs(int[][] matrix, int r, int c, int[][] dp) {
//         if (dp[r][c] != 0) {
//             return dp[r][c];
//         }

//         int curLongest = 1;
//         for (int[] d : DIRS) {
//             int nr = r + d[0];
//             int nc = c + d[1];

//             if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length) {
//                 continue;
//             }

//             if (matrix[nr][nc] > matrix[r][c]) {
//                 curLongest = Math.max(curLongest, 1 + dfs(matrix, nr, nc, dp));
//             }
//         }
//         dp[r][c] = curLongest;
//         return curLongest;
//     }
// }

class Solution {
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res = Math.max(res, dfs(matrix, r, c, dp));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int longest = 0;
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && 
            matrix[nr][nc] > matrix[r][c]) {
                longest = Math.max(longest, dfs(matrix, nr, nc, dp));
            }
        }
        dp[r][c] = longest + 1;
        return dp[r][c];
    }
}



// brute force
// class Solution {

//     static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

//     public int longestIncreasingPath(int[][] matrix) {

//         int m = matrix.length;
//         int n = matrix[0].length;

//         int res = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 res = Math.max(res, dfs(matrix, i, j));
//             }
//         }
//         return res;
//     }

//     private int dfs(int[][] matrix, int i, int j) {
//         int res = 0;
//         for (int[] d : DIRS) {
//             int x = i + d[0];
//             int y = j + d[1];
//             if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
//                 res = Math.max(res, dfs(matrix, x, y));
//             }
//         }
//         return res + 1;
//     }
// }

/**
3 4
3 2
 */