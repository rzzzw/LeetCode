class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int pre = nums[0];
        int globalMax = pre;
        for (int i = 1; i < nums.length; i++) {
            // if (nums[i] + pre > nums[i]) {
            //     pre = nums[i] + pre;
            // } else {
            //     pre = nums[i];
            // }
            pre = Math.max(nums[i] + pre, nums[i]);
            globalMax = Math.max(pre, globalMax);
        }
        return globalMax;
    }
}