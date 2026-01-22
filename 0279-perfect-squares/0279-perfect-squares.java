class Solution {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int[] M = new int[n + 1];
        M[0] = 0;
        for (int i = 1; i <= n; i++) {
            M[i] = i; //initialize w worst case, maximum i cuts - all are 1^2 
                      //cautions: M[i] default as 0 if not assign any other value
            for (int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i - j * j] + 1, M[i]);
            }
        }
        return M[n];
    }
}

// TC: n * sqt(n)
// SC: n

/**
dp[i] = minimum number of squares to sum to i

For each i, try all square numbers j*j ≤ i:
    dp[i] = min(dp[i - j*j] + 1)

Base case: dp[0] = 0

 */

