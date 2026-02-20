class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = cur + pre;
            pre = cur;
            cur = tmp;
            
        }
        return cur;
    }
}

/**
DP definition/state: dp[i] = number of distinct ways to reach the top
DP transition:       dp[i] = dp[i - 1] + dp[i - 2];
 */