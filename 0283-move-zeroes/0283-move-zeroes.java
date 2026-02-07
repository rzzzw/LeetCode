// class Solution {
//     public void moveZeroes(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return;
//         } 
//         int slow = 0;
//         for (int fast = 0; fast < nums.length; fast++) {
//             if (nums[fast] != 0) {
//                 if (fast != slow) {
//                     nums[slow] = nums[fast];
//                 }
//                 slow++;
//             }     
//         }
//         while (slow < nums.length) {
//             nums[slow] = 0;
//             slow++;
//         }
//     }
// }

// class Solution {
//     public void moveZeroes(int[] nums) {
//         int l = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 swap(nums, l, i);
//                 l++; 
//             } 
//         }
//     }

//     private void swap(int[] nums, int a, int b) {
//         int temp = nums[a];
//         nums[a] = nums[b];
//         nums[b] = temp;
//     }
// }



// 两个档板， 三个区域
// [0 ... slow-1]   → all non-zero, in original order
// [slow ... i-1]   → all zeros
// [i ... end]      → unexplored

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}