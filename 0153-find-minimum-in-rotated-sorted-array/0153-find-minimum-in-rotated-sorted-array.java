class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0; 
        int r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];

        int min = Integer.MAX_VALUE;
        while (l < r) {            
            int m = l + (r - l) / 2;
            if(nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }

            if (nums[m - 1] > nums[m]) {
                return nums[m];
            }
            if (nums[m] > nums[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return Integer.MAX_VALUE;
    }
}