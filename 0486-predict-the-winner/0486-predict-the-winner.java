class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];  
        return optimalSelection(nums, 0, n - 1, dp) >= 0;
    }
    private int optimalSelection(int[] nums, int l, int r, int[][] dp) {
        if (l == r) return nums[l];
        
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        
        int getLeft = nums[l] - optimalSelection(nums, l + 1, r, dp);
        int getRight = nums[r] - optimalSelection(nums, l, r - 1, dp);
        dp[l][r] = Math.max(getLeft, getRight);
        return dp[l][r];
    }
}

/*
dp[l][r]: the optimal score difference Player 1 can achieve by considering 2 possible choices: taking the leftmost element (nums[l]) or the rightmost element (nums[r]).

time complexity: O(n^2)
**/