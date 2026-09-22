class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] count = new int[]{0};
        helper(nums, target, 0, 0, count);
        return count[0];
    }
    private void helper(int[] nums, int target, int idx, int sum, int[] count){
        if (idx == nums.length) {
            if (sum == target) {
                count[0]++;
            }
            return;
        }

        // "+"
        sum += nums[idx];
        helper(nums, target, idx + 1, sum, count);
        sum -= nums[idx];

        // "-"
        sum += nums[idx] * (-1);
        helper(nums, target, idx + 1, sum, count);
    }

}