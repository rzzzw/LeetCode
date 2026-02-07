// /**
// Approach 1: 两个档板， 三个区域
// [0 ... slow-1]   → all non-zero, in original order
// [slow ... i-1]   → all zeros
// [i ... end]      → unexplored
//  */
// class Solution {
//     public void moveZeroes(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return;
//         }
//         int slow = 0;
//         for (int fast = 0; fast < nums.length; fast++) {
//             if (nums[fast] != 0) {
//                 swap(nums, fast, slow);
//                 slow++;
//             }
//         }
//     }
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }

/**
Approach 2: Overwrite + Fill Zeros
Step 1: Copy non-zero elements forward
Step 2: Fill the rest with zeros
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx] = num;
                idx++;
            }
        }
        while (idx < nums.length) {
            nums[idx] = 0;
            idx++;
        }
    }
}