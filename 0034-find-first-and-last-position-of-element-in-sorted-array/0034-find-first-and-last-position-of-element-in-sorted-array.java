// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int leftBound = findBound(nums, target, true);
//         if (leftBound == -1) {
//             return new int[]{-1, -1};
//         }
//         int rightBound = findBound(nums, target, false);
//         return new int[]{leftBound, rightBound};
//     }

//     private int findBound(int[] nums, int target, boolean isLeftBound) {
//         if(nums == null || nums.length == 0) {
//             return -1;
//         }
//         int n = nums.length;
//         int lo = 0;
//         int hi = n -1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) {
//                 if (isLeftBound) {
//                     if (mid == lo || nums[mid - 1] != target) {
//                         return mid;
//                     }
//                     hi = mid - 1;
//                 } else {
//                     if (mid == hi || nums[mid + 1] != target) {
//                         return mid;
//                     }
//                     lo = mid + 1;
//                 }
//             } else if (nums[mid] > target) {
//                 hi = mid - 1;
//             } else {
//                 lo = mid + 1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    // Find leftmost (first) occurrence
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // keep searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find rightmost (last) occurrence
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // keep searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
