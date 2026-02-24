/**
dp[i] = max subarray sum ending at i
At index i, we have two choices:
  - Extend previous subarray
    dp[i-1] + nums[i]
  - Start fresh at i
    nums[i]
=> dp[i] = max(nums[i], dp[i-1] + nums[i])

 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int current = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            globalMax = Math.max(globalMax, current);
        }
        return globalMax;
    }
}

