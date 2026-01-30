class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }
}


/**
DP (overkill)
dp[i] = whether index i is reachable
Transition: dp[j] = true if any dp[i] is true and j ≤ i + nums[i]
Time complexity: O(n²) ❌



 */