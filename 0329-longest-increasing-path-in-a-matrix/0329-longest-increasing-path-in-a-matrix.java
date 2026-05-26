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


class Solution {

    public static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, dp));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {

        // already computed
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int curLongest = 1;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length) {
                continue;
            }

            // increasing condition
            if (matrix[nr][nc] > matrix[r][c]) {
                curLongest = Math.max(curLongest, 1 + dfs(matrix, nr, nc, dp));
            }
        }
        dp[r][c] = curLongest;

        return curLongest;
    }
}
