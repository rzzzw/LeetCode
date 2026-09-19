class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int r = 0; r < rows; r++) {
            dp[r][0] = matrix[r][0] - '0';
            maxSide = Math.max(maxSide, dp[r][0]);
        }

        for (int c = 0; c < cols; c++) {
            dp[0][c] = matrix[0][c] - '0';
            maxSide = Math.max(maxSide, dp[0][c]);
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c], Math.min(dp[r - 1][c - 1], dp[r][c - 1]));
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        } 
        return maxSide * maxSide;
    }
}