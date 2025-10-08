// class Solution {
//     public int search(int[] nums, int target) {
//         int lo = 0;
//         int hi = nums.length - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) {
//                 return mid;
//             } else if (nums[lo] <= nums[mid]) {
//                 if (target < nums[mid] && target >= nums[lo]) {
//                     hi = mid - 1;
//                 } else {
//                     lo = mid + 1;
//                 }
//             } else {
//                 if (target > nums[mid] && target <= nums[hi]) {
//                     lo = mid + 1;
//                 } else {
//                     hi = mid - 1;
//                 }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
}