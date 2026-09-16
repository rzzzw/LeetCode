// class Solution{
//     public int maxProduct(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int max = nums[0];
//         int min = nums[0];
//         int res = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             int preMax = max;
//             max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
//             min = Math.min(Math.min(preMax * nums[i], min * nums[i]), nums[i]); // 注意此时 max 已经更新，用tmp
//             res = Math.max(res, max);
//         }
//         return res;
//     }
// }


/**
        [2,3,-2,4]

min 2   2   -12 -48
max 2   6   -2  4
res 2   6   6   6

 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0]; // a smallest negative number can make the product huge
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            // compare self, self * max, self * min
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * preMax, nums[i] * min), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}

/**

 */